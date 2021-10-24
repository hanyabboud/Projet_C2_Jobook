package lb.cnam.c2.v1.apis.utils;

import org.json.JSONObject;

public class JobUtils {

	public static String getSortsQuery(JSONObject bodyJO) {
		String sortsQuery = "";
		
		boolean sort_date_newest = true;
		boolean sort_date_oldest = false;
		boolean sort_name_ascending = false;
		boolean sort_name_descending = true;
		
		try {
			if(bodyJO.has("sorts")) {
				JSONObject sortsJO = bodyJO.getJSONObject("sorts");
				
				try {
					if(sortsJO.has("date")) {
						JSONObject dateJO = sortsJO.getJSONObject("date");
						
						if(dateJO.has("newest")) {
							sort_date_newest = dateJO.getBoolean("newest");
							sort_date_oldest = !sort_date_newest;
						} else if(dateJO.has("oldest")) {
							sort_date_oldest = dateJO.getBoolean("oldest");
							sort_date_newest = !sort_date_oldest;
						}
					}
				} catch(Exception sortDateException) {
					sortDateException.printStackTrace();
					// Default values
					sort_date_newest = true;
					sort_date_oldest = false;
				}
				
				try {
					if(sortsJO.has("name")) {
						JSONObject dateJO = sortsJO.getJSONObject("name");
						
						if(dateJO.has("ascending")) {
							sort_name_ascending = dateJO.getBoolean("ascending");
							sort_name_descending = !sort_name_ascending;
						} else if(dateJO.has("descending")) {
							sort_name_descending = dateJO.getBoolean("descending");
							sort_name_ascending = !sort_name_descending;
						}
					}
				} catch(Exception sortDateException) {
					sortDateException.printStackTrace();
					// Default values
					sort_name_ascending = false;
					sort_name_descending = true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// Sort by date
		if(sort_date_oldest) {
			sortsQuery += "j.creation_date DESC";
		} else if(sort_date_newest) {
			sortsQuery += "j.creation_date ASC";
		}
		
		// Sort by name
		if(sort_name_descending) {
			if(sortsQuery.length() > 0) sortsQuery += ", ";
			sortsQuery += "j.title DESC";
		} else if(sort_name_ascending) {
			if(sortsQuery.length() > 0) sortsQuery += ", ";
			sortsQuery += "j.title ASC";
		}
		
		sortsQuery = "ORDER BY " + sortsQuery;
		
//		final boolean sort_date_newest_final = sort_date_newest;
//		final boolean sort_date_oldest_final = sort_date_oldest;
//		final boolean sort_name_ascending_final = sort_name_ascending;
//		final boolean sort_name_descending_final = sort_name_descending;
//		
//		jobs.sort(new Comparator<JobModal>() {
//
//			@Override
//			public int compare(JobModal j1, JobModal j2) {
//				int score = 0;
//				
//				// Get Creation Dates and substring by day
//				String creationDate1 = j1.getJobCreationDate().substring(0, 10);
//				String creationDate2 = j2.getJobCreationDate().substring(0, 10);
//				
//				// Get titles
//				String title1 = j1.getJobTitle();
//				String title2 = j2.getJobTitle();
//
//				// Sort by date
//				if(sort_date_oldest_final) {
//					score = creationDate1.compareTo(creationDate2);
//				} else if(sort_date_newest_final) {
//					score = creationDate2.compareTo(creationDate1);
//				}
//				
//				if(score != 0) return score;
//				
//				// Sort by name
//				if(sort_name_descending_final) {
//					score = title2.compareTo(title1);
//				} else if(sort_name_ascending_final) {
//					score = title1.compareTo(title2);
//				}
//				
//				return score;
//			}
//		});
		
		return sortsQuery;
	}
	
	public static String getFiltersQuery(JSONObject bodyJO) {
		String filtersQuery = "";
		try {
			if(bodyJO.has("filters")) {
				JSONObject filtersJO = bodyJO.getJSONObject("filters");
				
				try {
					if(filtersJO.has("experience")) {
						int experience = filtersJO.getInt("experience");
						filtersQuery += "AND j.experience = " + experience + " ";
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					if(filtersJO.has("environment")) {
						int environment = filtersJO.getInt("environment");
						filtersQuery += "AND j.environment = " + environment + " ";
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				try {
					if(filtersJO.has("type")) {
						int type = filtersJO.getInt("type");
						filtersQuery += "AND j.type = " + type + " ";
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return filtersQuery;
	}
	
	public static String getSearchQuery(String search) {
		if(search != null && search.trim().length() == 0) return "";
		String searchQuery = "AND (";
		
		searchQuery += "jexp.name like '%" + search + "%' ";
		searchQuery += "OR jenv.name like '%" + search + "%' ";
		searchQuery += "OR jt.name like '%" + search + "%' ";
		searchQuery += "OR j.title like '%" + search + "%' ";
		searchQuery += "OR j.description like '%" + search + "%' ";
		searchQuery += "OR j.creation_date like '%" + search + "%' ";
		
		searchQuery += ") ";
		
		return searchQuery;
	}
	
}
