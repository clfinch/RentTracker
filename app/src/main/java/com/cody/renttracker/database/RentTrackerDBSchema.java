package com.cody.renttracker.database;

/**
 * This class sets up the DB Schema for our 3 tables
 */

public class RentTrackerDBSchema {
    public static final class TenantTable {
        public static final String NAME = "tenants";

        public static final class Cols {
            public static final String TENANTNAME = "tenantname";
            public static final String PAID = "paid";
            public static final String MONTHNAME = "monthname";
        }
    }// end TenantTable

    public static final class MonthTable{
        public static final String NAME = "months";

        public static final class Cols{
            public static final String MONTHNAME = "monthname";
            public static final String AMOUNT = "amount";
        }
    }

    public static final class BillTable{
        public static final String NAME = "bills";

        public static final class Cols{
            public static final String BILLNAME = "billname";
            public static final String AMOUNT = "amount";
            public static final String MONTHNAME = "monthname";
        }
    }
}
