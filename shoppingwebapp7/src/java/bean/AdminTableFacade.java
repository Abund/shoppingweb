/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.AdminTable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Abun
 */
@Stateless
public class AdminTableFacade extends AbstractFacade<AdminTable> {

    @PersistenceContext(unitName = "shoppingwebapp7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminTableFacade() {
        super(AdminTable.class);
    }
    
}
