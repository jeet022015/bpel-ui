package be.ac.fundp.precise.dataManagment;

import be.ac.fundp.precise.dataManagment.hibernate.DataManagerHibernate;

public class DataManagerFactory {

	public static DataManager hibernateDataManager() {
		return new DataManagerHibernate();
	}

}
