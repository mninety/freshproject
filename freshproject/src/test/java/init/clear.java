package init;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import utils.TestData;

public class clear {
	
	TestData testdata;
	
	@Test
	public void clearDB_afterTest() throws ClassNotFoundException, SQLException, IOException {
		
		//System.out.println("After suite");
		
		testdata = new TestData();
		Connection  conn = DriverManager.getConnection(testdata.properties.getProperty("DB"),
				testdata.properties.getProperty("dbusername"), testdata.properties.getProperty("dbpassword"));

		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
        Statement st =  conn.createStatement();
        st.executeUpdate("delete from trip_meta;");
        st.executeUpdate("delete from vehicle_and_driver_review;");
        
        st.executeUpdate("delete from bids_on_trip;");
        st.executeUpdate("delete from trip_action_log;");
 
        st.executeUpdate("delete from trip_notification_reminder;");
        st.executeUpdate("delete from user_trip_rating");
        st.executeUpdate("delete from trip_additional_data");
        st.executeUpdate("delete from trip_group;");
        st.executeUpdate("delete from trip_details;");
 
        st.executeUpdate("delete from truck_tracker");
        st.executeUpdate("delete from truck_migration_log");
        st.executeUpdate("delete from truck_admin_comment");
        st.executeUpdate("delete from user_truck_details_review;");
        st.executeUpdate("delete from user_truck_deletion_review;");
  		st.executeUpdate("delete from user_truck_photos;");
  		st.executeUpdate("delete from user_truck_photos_review;");
  		st.executeUpdate("delete from user_truck_details;");
  		st.executeUpdate("delete from vehicle_and_driver_review;");
  		
        st.executeUpdate("delete from call_request_log");
        st.executeUpdate("delete from call_request_drop_off");
        st.executeUpdate("delete from call_request_goods");
        st.executeUpdate("delete from call_request");
        st.executeUpdate("delete from return_request");
        
               
  		
        st.executeUpdate("delete from project");
        st.executeUpdate("delete from distributor_details");
        st.executeUpdate("delete from enterprise_distributor_mapping");
        st.executeUpdate("delete from company_distributor_mapping");
        st.executeUpdate("delete from company_user");
        st.executeUpdate("delete from company_bank");
        st.executeUpdate("delete from company");
        st.executeUpdate("delete from partner_service_payment");
        st.executeUpdate("delete from partner_payment");
         st.executeUpdate("delete from agent");
        //st.executeUpdate("delete from enterprise_customer");
        st.executeUpdate("delete from agent_document");
        st.executeUpdate("delete from user_app_time");
        st.executeUpdate("delete from company_user");
        st.executeUpdate("delete from user_truck_deletion_review");
        st.executeUpdate("delete from admin_bid_action_log");
        st.executeUpdate("delete from truck_migration_log");
        st.executeUpdate("delete from user_meta_data");
        st.executeUpdate("delete from reward_payment");
        st.executeUpdate("delete from referral_reward");
      		st.executeUpdate("delete from trip_meta");
      		st.executeUpdate("delete from user_referral_mapping");
              st.executeUpdate("delete from truck_tracker;");
                st.executeUpdate("delete from user_action_log;");
              st.executeUpdate("delete from api_log;"); 
              st.executeUpdate("delete from audit_activity;");
      		st.executeUpdate("delete from audit_log;");
      		st.executeUpdate("delete from audit_login;");
      		st.executeUpdate("delete from device_details;");
      		st.executeUpdate("delete from driver_fleet_owner_mapping;");
      		st.executeUpdate("delete from driver_fleet_owner_mapping_review;");
      		st.executeUpdate("delete from forgot_password;");
      		st.executeUpdate("delete from notification;");
      		st.executeUpdate("delete from running_trip_details;");
      		st.executeUpdate("delete from sub_admins_permissions;");
      		st.executeUpdate("delete from trip_and_seeker_review;");
      		st.executeUpdate("delete from truck_admin_comment;");
      		 st.executeUpdate("delete from master_product_type");
             st.executeUpdate("delete from company_action_log");
             st.executeUpdate("delete from company");
             st.executeUpdate("delete from user_app_time");
             st.executeUpdate("delete from agent_document");
             st.executeUpdate("delete from agent");
             st.executeUpdate("delete from forgot_password");
             st.executeUpdate("delete from tracker_access");
             st.executeUpdate("delete from user_meta_data");
             st.executeUpdate("delete from reward_payment");
             st.executeUpdate("delete from referral_reward");
           		st.executeUpdate("delete from trip_meta");
           		st.executeUpdate("delete from user_referral_mapping");
             st.executeUpdate("delete from user_action_log");
             st.executeUpdate("delete from user_bank_details;");
       		st.executeUpdate("delete from user_bank_details_review;");
       		st.executeUpdate("delete from user_company_details;");
       		st.executeUpdate("delete from user_company_details_review;");
       		st.executeUpdate("delete from user_company_admin_action_audit;");
       		st.executeUpdate("delete from user_driver_details;");
       		st.executeUpdate("delete from user_driver_details_review;");
       		st.executeUpdate("delete from user_gateway_details;");
       		st.executeUpdate("delete from user_gateway_details_review;");
       		st.executeUpdate("delete from user_otp;");
       		st.executeUpdate("delete from user_review;");
       		st.executeUpdate("delete from user_security_policy where user_id not in (\"2923\", \"505786\", \"57881\", \"57882\", \"57883\", \"585028\");");
       		st.executeUpdate("delete from user_role_mapping where user_id not in (\"2923\", \"505786\", \"57881\", \"57882\", \"57883\", \"585028\");");
       		st.executeUpdate("delete from user where email not in (\"admin-automation@gmail.com\", \"ejogajoguser@gmail.com\", \"mzaman@ejogajogbd.com\", \"testpartner123@test.com\", \"testcustomer123@test.com\", \"mrahman@ejogajogbd.com\");");
       		st.executeUpdate("delete from user where email is null;");
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		conn.close();
        //System.out.println("Check if the DB query is executed and connection is closed: "+conn.isClosed());
		}
		
		
	}
	

	
	
	@Test
	public void clearDB_afterTest1() throws ClassNotFoundException, SQLException, IOException {
		
		System.out.println("After suite");
		
		testdata = new TestData();
		Connection  conn = DriverManager.getConnection(testdata.properties.getProperty("DB"),
				testdata.properties.getProperty("dbusername"), testdata.properties.getProperty("dbpassword"));

		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
        Statement st =  conn.createStatement();
        st.executeUpdate("delete from master_product_type");
        st.executeUpdate("delete from company_action_log");
        st.executeUpdate("delete from company");
        st.executeUpdate("delete from user_app_time");
        st.executeUpdate("delete from agent_document");
        st.executeUpdate("delete from agent");
        st.executeUpdate("delete from forgot_password");
        st.executeUpdate("delete from tracker_access");
        st.executeUpdate("delete from user_meta_data");
        st.executeUpdate("delete from reward_payment");
        st.executeUpdate("delete from referral_reward");
      		st.executeUpdate("delete from trip_meta");
      		st.executeUpdate("delete from user_referral_mapping");
        st.executeUpdate("delete from user_action_log");
        st.executeUpdate("delete from user_bank_details;");
  		st.executeUpdate("delete from user_bank_details_review;");
  		st.executeUpdate("delete from user_company_details;");
  		st.executeUpdate("delete from user_company_details_review;");
  		st.executeUpdate("delete from user_company_admin_action_audit;");
  		st.executeUpdate("delete from user_driver_details;");
  		st.executeUpdate("delete from user_driver_details_review;");
  		st.executeUpdate("delete from user_gateway_details;");
  		st.executeUpdate("delete from user_gateway_details_review;");
  		st.executeUpdate("delete from user_otp;");
  		st.executeUpdate("delete from user_review;");
  		st.executeUpdate("delete from user_security_policy where user_id not in (\"2923\", \"505786\", \"57881\", \"57882\", \"57883\", \"585028\");");
  		st.executeUpdate("delete from user_role_mapping where user_id not in (\"2923\", \"505786\", \"57881\", \"57882\", \"57883\", \"585028\");");
  		st.executeUpdate("delete from user where email not in (\"admin-automation@gmail.com\", \"ejogajoguser@gmail.com\", \"mzaman@ejogajogbd.com\", \"testpartner123@test.com\", \"testcustomer123@test.com\", \"mrahman@ejogajogbd.com\");");
  		st.executeUpdate("delete from user where email is null;");
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		conn.close();
        //System.out.println("Check if the DB query is executed and connection is closed: "+conn.isClosed());
		}
		
		
	}

	
}
