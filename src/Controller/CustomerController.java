package Controller;

import db.DBConnection;
import model.Customer;
import model.CustomerList;

import java.util.Arrays;

    public class CustomerController {
        public static Controller.CustomerController CustomerController;

        public static boolean addCustomer(Customer customer) {
            CustomerList customerList = DBConnection.getInstance().getCustomerList();
            customerList.add(customer);
            return true;
        }

        public static Customer[] getAllCustomer() {
            CustomerList customerList = DBConnection.getInstance().getCustomerList();
            return customerList.toArray();
        }

        public static Customer[] getAllCustomerSortBySalary() {
            CustomerList customerList = DBConnection.getInstance().getCustomerList();
            Customer[] customerArray = customerList.toArray();
            for (int i = 1; i < customerArray.length; i++) {
                for (int j = 0; j < customerArray.length - i; j++) {
                    if (customerArray[j].getSalary() > customerArray[j + 1].getSalary()) {
                        Customer tempCustomer = customerArray[j];
                        customerArray[j] = customerArray[j + 1];
                        customerArray[j + 1] = tempCustomer;
                    }
                }
            }
            return customerArray;
        }

        public static Customer searchCustomer(String id) {
            CustomerList customerList = DBConnection.getInstance().getCustomerList();
            Customer customer = new Customer(id, null, null, null, 0.0, null);
            int index = customerList.indexOf(customer);
            return customerList.get(index);
        }

        public static boolean updateCustomer(Customer customer) {
            CustomerList customerList = DBConnection.getInstance().getCustomerList();
            int index = customerList.indexOf(customer);
            customerList.remove(index);
            customerList.add(index, customer);
            return true;
        }

        public static boolean deleteCustomer(Customer customer) {
            CustomerList customerList = DBConnection.getInstance().getCustomerList();
            int index = customerList.indexOf(customer);
            customerList.remove(index);
            return true;
        }

        public static String lastId() {
            CustomerList customerList = DBConnection.getInstance().getCustomerList();
            String[] idArray = new String[customerList.size()];
            for (int i = 0; i < customerList.size(); i++) {
                idArray[i] = customerList.get(i).getId();
            }
            Arrays.sort(idArray);
            return idArray.length == 0 ? null : idArray[idArray.length - 1];
        }

        public static Customer[] getAllCustomerSortByBirthday() {
            CustomerList customerList = DBConnection.getInstance().getCustomerList();
            Customer[] customerArray = customerList.toArray();
            for (int i = 1; i < customerArray.length; i++) {
                for (int j = 0; j < customerArray.length - i; j++) {
                    if (customerArray[j].getBirthday().compareTo(customerArray[j + 1].getBirthday()) > 0) {
                        Customer tempCustomer = customerArray[j];
                        customerArray[j] = customerArray[j + 1];
                        customerArray[j + 1] = tempCustomer;
                    }
                }
            }
            return customerArray;


        }
        public static Customer[] getAllCustomerSortByName () {
            CustomerList customerList = DBConnection.getInstance().getCustomerList();
            Customer[] customerArray = customerList.toArray();
            for (int i = 1; i < customerArray.length; i++) {
                for (int j = 0; j < customerArray.length - i; j++) {
                    if (customerArray[j].getName().compareToIgnoreCase(customerArray[j + 1].getName()) > 0) {
                        Customer tempCustomer = customerArray[j];
                        customerArray[j] = customerArray[j + 1];
                        customerArray[j + 1] = tempCustomer;
                    }
                }
            }
            return customerArray;
        }
    }


