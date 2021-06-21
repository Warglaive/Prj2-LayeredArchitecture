package com.flighttickets.BusinessLogic;

import com.flighttickets.Entities.*;
import com.flighttickets.PGDataSource;
import com.flighttickets.Persistance.BookingRequestStorageService;
import com.flighttickets.Persistance.PersistenceAPI;
import com.flighttickets.Persistance.PersistenceImplementationProvider;
import com.flighttickets.Persistance.TicketStorageService;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TicketManagerImplTest {
    private TicketManager ticketManager;

    private TicketStorageService ticketStorageService;


    private BusinessLogicAPI businesslogicAPI;
    private PersistenceAPI persistenceAPI;

    private Ticket addedTicket;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        PGDAOFactory daoFactory = new PGDAOFactory(PGDataSource.DATA_SOURCE);

        // Register mappers for the classes in this app
        daoFactory.registerMapper(Ticket.class, new TicketMapper());


        this.persistenceAPI = PersistenceImplementationProvider.getPersistenceImplementation(daoFactory);
        this.businesslogicAPI = BusinessLogicImplementationProvider.getImplementation(persistenceAPI);

        this.ticketManager = this.businesslogicAPI.getTicketManager();


        this.ticketManager.setTicketStorageService(this.persistenceAPI.getTicketStorageService());
        this.ticketStorageService = this.persistenceAPI.getTicketStorageService();
        Ticket toAdd = this.ticketManager.createTicket(1, 50, 1, 1, 1, "ForSale");
        this.ticketManager.add(toAdd);

        List<Ticket> allTickets = this.ticketManager.getAll();
        this.addedTicket = allTickets.get(allTickets.size()-1);

    }
    @Test
    void createTicketTest(){
        Ticket Actual = this.ticketManager.createTicket(1, 50, 1, 1, 1, "ForSale");
        Ticket Expected = new Ticket(1, 50, 1, 1, 1, "ForSale");

        assertThat(Actual).usingRecursiveComparison().isEqualTo(Expected);

    }


    @Test
    void getAllTest(){
        List<Ticket> allTickets = this.ticketManager.getAll();
        List<Ticket> allTicketsExpected = this.ticketStorageService.getAll();

        assertThat(allTickets).usingRecursiveComparison().isEqualTo(allTicketsExpected);
    }

    @Test
    void addTicketTest() throws SQLException, ClassNotFoundException {
        Ticket toAdd = this.ticketManager.createTicket(1, 50, 1, 1, 1, "ForSale");
        this.ticketManager.add(toAdd);

        List<Ticket> allTickets = this.ticketManager.getAll();
        Ticket addedTicket = allTickets.get(allTickets.size()-1);

        assertThat(toAdd).usingRecursiveComparison().ignoringFields("ticketid").isEqualTo(addedTicket);
    }
    @Test
    void getByIdTest() throws SQLException, ClassNotFoundException {
        Ticket toAdd = this.ticketManager.createTicket(1, 50, 1, 1, 1, "ForSale");
        this.ticketManager.add(toAdd);

        List<Ticket> allTickets = this.ticketManager.getAll();
        Ticket addedTicket = allTickets.get(allTickets.size()-1);

        Ticket actual = this.ticketManager.getById(addedTicket.getId());
        assertThat(actual).usingRecursiveComparison().isEqualTo(addedTicket);
    }
    @Test
    void editTicketTest() throws SQLException, ClassNotFoundException {
        Ticket toAdd = this.ticketManager.createTicket(1, 50, 1, 1, 1, "ForSale");
        this.ticketManager.add(toAdd);

        List<Ticket> allTickets = this.ticketManager.getAll();
        Ticket addedTicket = allTickets.get(allTickets.size()-1);
        Ticket newTicket =  this.ticketManager.createTicket(1, 50, 1, 1, 2, "ForSale");
        this.ticketManager.edit(addedTicket.getId(), newTicket);

        Ticket NewTicketFetched = this.ticketManager.getById(addedTicket.getId());

        assertThat(NewTicketFetched).usingRecursiveComparison().ignoringFields("ticketid").isNotEqualTo(addedTicket);
        assertThat(NewTicketFetched).usingRecursiveComparison().ignoringFields("ticketid").isEqualTo(newTicket);
    }
    @Test
    void getOpenTicketsTest(){
        List<Ticket> forSaleAmsterdam = this.ticketManager.getOpenTickets("Schiphol");
        forSaleAmsterdam.removeIf(el -> el.getId() != addedTicket.getId());

        Ticket Ticket = forSaleAmsterdam.get(0);

        assertThat(Ticket).usingRecursiveComparison().isEqualTo(addedTicket);

    }
    @Test
    void sellTicketTest(){
        List<Ticket> forSaleAmsterdam = this.ticketManager.getOpenTickets("Schiphol");
        forSaleAmsterdam.removeIf(el -> el.getId() != addedTicket.getId());
        this.ticketManager.sell(1,addedTicket);
        List<Ticket> forSaleAmsterdamAfter = this.ticketManager.getOpenTickets("Schiphol");
        forSaleAmsterdamAfter.removeIf(el -> el.getId() != addedTicket.getId());

        assertThat(forSaleAmsterdam).usingRecursiveComparison().isNotEqualTo(forSaleAmsterdamAfter);
    }

}
