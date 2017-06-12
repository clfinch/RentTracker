package com.cody.renttracker.database;

/**
 * This class sets up the DB Schema for our 3 tables
 */

public class RentTrackerDBSchema {
    public static final class TenantTable {
        public static final String NAME = "tenant";

        public static final class Cols {
            public static final String TENANTID = "tenantid";
            public static final String FIRSTNAME = "firstname";
            public static final String LASTNAME = "lastname";
        }
    }// end TenantTable

    public static final class MonthTable{
        public static final String NAME = "month";

        public static final class Cols{
            public static final String MONTHID = "monthid";
            public static final String MONTHNAME = "monthname";
            public static final String AMOUNT = "amount";
        }
    }

    public static final class BillTable{
        public static final String NAME = "bill";

        public static final class Cols{
            public static final String BILLID = "billid";
            public static final String BILLNAME = "billname";
            public static final String AMOUNT = "amount";
            public static final String MONTHID = "monthid";
        }
    }

    public static final class TenantMonthTable{
        public static final String NAME = "tenantmonth";

        public static final class Cols{
            public static final String TENANTID = "tenantid";
            public static final String MONTHID = "monthid";
            public static final String PAID = "paid";
        }
    }
}
