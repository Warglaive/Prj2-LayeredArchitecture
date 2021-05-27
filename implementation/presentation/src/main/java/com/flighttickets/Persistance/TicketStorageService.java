package com.flighttickets.Persistance;

import com.flighttickets.Entities.Ticket;
import com.flighttickets.Entities.TicketMapper;
import com.flighttickets.PGDataSource;
import nl.fontys.sebivenlo.dao.pg.PGDAO;
import nl.fontys.sebivenlo.dao.pg.PGDAOFactory;

import java.util.List;

public class TicketStorageService {

    private PGDAO<Integer, Ticket> ticketDAO;

    public TicketStorageService(PGDAOFactory daoFactory){
        daoFactory.registerMapper(Ticket.class, new TicketMapper());
        // get a dao (no transactions yet).
        this.ticketDAO = daoFactory.createDao(Ticket.class);
    }

    public List<Ticket> getAll(){
        return this.ticketDAO.getAll();
    }

    public void insert(Ticket ticket){
        this.ticketDAO.save(ticket);
    }
    public void update(Ticket ticket){
        this.ticketDAO.update(ticket);
    }
}
