package be.ac.fundp.precise.dataManagment;

import be.ac.fundp.precise.dataManagment.hibernate.NewDataManagerHibernate;

/**
 * A factory for creating DataManager objects.
 * 
 * @author Waldemar Pires Ferreira Neto (waldemar.neto@fundp.ac.be)
 * @date May 22, 2012
 */
public class DataManagerFactory {

/**
 * Hibernate data manager.
 *
 * @return the new data manager hibernate
 */
public static NewDataManagerHibernate hibernateDataManager() {
		return new NewDataManagerHibernate();
	}

}
