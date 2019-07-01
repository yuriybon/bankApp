package ua.bondary.bankapp.finance.dao;

import ua.bondary.bankapp.finance.domain.Bank;

import java.sql.SQLException;
import java.util.List;

public interface BankDao {

        //create
        void add(Bank bank);
        //void addFoodtypeToRestaurant(Foodtype foodtype, Restaurant restaurant);

        //read
        List<Bank> getAll();
        // List<Restaurant> getAllRestaurantsForAFoodtype(int id);
        Bank getBankById(int bankId) throws SQLException;

        //update
        //omit for now

        //delete
        void deleteById(int id);
        void clearAll();
    }