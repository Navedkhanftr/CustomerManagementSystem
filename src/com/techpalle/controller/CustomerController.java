package com.techpalle.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.CustomerDao;
import com.techpalle.model.Customer;


@WebServlet("/")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path=request.getServletPath();
		switch(path)
		{
		case "/delete":
			deleteCustomer(request,response);
			break;
		case "/edit":
			getupdateForm(request,response);
			break;
		case "/editForm":
			getEditForm(request,response);
			break;
		case "/add":
			getInsertForm(request,response);
			break;
		case "/insertForm":
			addCustomer(request,response);
			break;
		default:
			getStartUpPage(request,response);
			break;
		}
	}

	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//read the id from url
		int i=Integer.parseInt(request.getParameter("id"));
		//call dao method
         CustomerDao.deleteCustomer(i);
         
         try 
 		{
        	 //redirect to home/list page
 			response.sendRedirect("list");
 		} 
         catch (IOException e) 
 		{
 			e.printStackTrace();
 		}
	}
    private void getupdateForm(HttpServletRequest request, HttpServletResponse response) 
	{
		int id=Integer.parseInt(request.getParameter("tbId"));
		String name=request.getParameter("tbName");
		String email=request.getParameter("tbEmail");
		long mobile=Long.parseLong(request.getParameter("tbMobile"));
		
		Customer c=new Customer(id,name,email,mobile);
		CustomerDao.updateCustomer(c);
		try 
		{
			response.sendRedirect("list");
		} catch (IOException e) 
		{
			e.printStackTrace();
		}


		
	}


	private void getEditForm(HttpServletRequest request, HttpServletResponse response) 
	{
		//fetch id from url
		
         try 
         {
        	 int i=Integer.parseInt(request.getParameter("id"));
     		
     		Customer c=CustomerDao.getOneCustomer(i);
             request.setAttribute("customer", c);

        	 RequestDispatcher rd= request.getRequestDispatcher("customerform.jsp");
			rd.forward(request, response);
		}
         catch (ServletException e) {
			e.printStackTrace();
		}
         catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void getInsertForm(HttpServletRequest request, HttpServletResponse response) 
	{
	        try
	        {
	   		 RequestDispatcher rd=request.getRequestDispatcher("customerform.jsp");
              rd.forward(request, response);
			} 
	        catch (ServletException e1) 
	        {
				e1.printStackTrace();
			} catch (IOException e1) 
	        {
				e1.printStackTrace();
			}
	}


	private void addCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
        String n=request.getParameter("tbName");
        String e=request.getParameter("tbEmail");		
        long m =Long.parseLong(request.getParameter("tbMobile"));        
        Customer c=new Customer(n,e,m);
        CustomerDao.addCustomer(c);
        
        getStartUpPage(request,response);
        //or use below for redirecting to home page
        
   /*     try {
            RequestDispatcher rd=request.getRequestDispatcher("customerlist.jsp");
			rd.forward(request, response);
		} catch (ServletException e1) 
        {
			e1.printStackTrace();
		} catch (IOException e1) 
        {
			e1.printStackTrace();
		}*/

	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			ArrayList<Customer>alCustomer=CustomerDao. getAllCustomers();
			RequestDispatcher rd  =request.getRequestDispatcher("customerlist.jsp");
            request.setAttribute("al", alCustomer);
			rd.forward(request, response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
