package com.techpalle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.techpalle.model.Customer;

public class CustomerDao 
 {
	   private static final String url="jdbc:mysql://localhost:3306/priya";
	   private static final String username="root";
	   private static final String password="admin";
	   
	   private static Connection con=null;
	   private static PreparedStatement ps=null;
	   private static Statement s=null;
	   private static ResultSet rs=null;
	   
	   private static final String customersListQry="select * from customer";
	   private static final String customerInsert="insert into customer(name,email,mobile)values(?,?,?)";
	   private static final String customerEdit="select * from customer where id=? ";
	   private static final String customerUpdate="update customer set name=?,email=?,mobile=? where id=?";
	   private static final String customerDelete="delete from customer where id=?";
	   
	   public static void deleteCustomer(int id)
	   {
		   try 
		   {
			con=getConnectionDef();

			ps=con.prepareStatement(customerDelete);
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
		   }
		   catch (SQLException e)
		   {
			e.printStackTrace();
		    }
		   finally
			 {
					if(ps!=null)
	                   if(con!=null)
					try 
					{
						ps.close();
						con.close();
					} 
				 catch (SQLException e) 
					{
						e.printStackTrace();
					}
			 }
	   }
	   public static void updateCustomer(Customer c)
	   {
		   try 
		   {
		   con=getConnectionDef();

			ps=con.prepareStatement(customerUpdate);
			ps.setString(1,c.getName());
			ps.setString(2,c.getEmail());
			ps.setLong(3,c.getMobile());
            ps.setInt(4, c.getId());
            
            ps.executeUpdate();

		} 
		   catch (SQLException e) 
		   {
			e.printStackTrace();
		}
		   finally
			 {
					if(ps!=null)
	                   if(con!=null)
					try 
					{
						ps.close();
						con.close();
					} 
				 catch (SQLException e) 
					{
						e.printStackTrace();
					}
			 }
	   }
	   
	   public static Customer getOneCustomer(int id)
	   {
		   Customer c=null;
          try 
          {
   		   con=getConnectionDef();
           ps=con.prepareStatement(customerEdit);
			ps.setInt(1, id);
			
			rs=ps.executeQuery();
			
			rs.next();
			
			int i=rs.getInt("id");
        	String n=rs.getString("name");
        	String e=rs.getString("email");
            long m=rs.getLong("mobile");
            c=new Customer(i,n,e,m);
		} 
          catch (SQLException e) 
          {
			e.printStackTrace();
		}
          finally
 		 {
 			 if(rs!=null)
 				 if(ps!=null)
                    if(con!=null)
 				try {
 					rs.close();
 					ps.close();
 					con.close();
 				} 
 			 catch (SQLException e) 
 			 {
 					e.printStackTrace();
 				}
 		 }
        
		   return c;
	   }
	   
	   public static void addCustomer(Customer customer)
	   {
		   con=getConnectionDef();
		  try 
		  {
			ps = con.prepareStatement(customerInsert);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setLong(3, customer.getMobile());
			
            ps.executeUpdate();
           } 
		  catch (SQLException e) 
		  {
			e.printStackTrace();
		  }
		  finally
			 {
					if(ps!=null)
	                   if(con!=null)
					try 
					{
						ps.close();
						con.close();
					} 
				 catch (SQLException e) 
					{
						e.printStackTrace();
					}
			 }
	   }
	   
	   public static Connection getConnectionDef()
	   {
		   try 
		   {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		   } 
		   catch (ClassNotFoundException e)
		   {
			e.printStackTrace();
		   } 
		   catch (SQLException e) 
		   {
			e.printStackTrace();
		}
		return con;
	   }
	   public static ArrayList<Customer> getAllCustomers()
	   {
		   ArrayList<Customer> al=new ArrayList<Customer>();
		 try 
		 {
			  con = getConnectionDef();
                 s= con.createStatement();
         		rs= s.executeQuery(customersListQry);
                while(rs.next())
                {
                	int i=rs.getInt("id");
                	String n=rs.getString("name");
                	String e=rs.getString("email");
                    long m=rs.getLong("mobile");
                    
                    Customer c=new Customer(i,n,e,m);
                    al.add(c);
                }
		 } 
		 catch (SQLException e) 
		 {
			e.printStackTrace();
		}
		 finally
		 {
			 if(rs!=null)
				 if(s!=null)
                   if(con!=null)
				try {
					rs.close();
					s.close();
					con.close();
				} 
			 catch (SQLException e) 
			 {
					e.printStackTrace();
				}
		 }
		return al;
		   
	   }
	   
	  
	   

 }
