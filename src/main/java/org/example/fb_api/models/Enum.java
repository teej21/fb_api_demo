package org.example.fb_api.models;

import lombok.Getter;

public class Enum {
    enum EventType {
        purchase,
        plan_upgrade,
        prepaid_to_postpaid_migration,
        esim_profile_installed,
        esim_profile_not_installed,
        esim_trial_converted_to_paid,
        esim_trial_finished
    }

    enum InventoryType {
        DATA_PACK,
        DATA_LOAN,
        MONETARY_STANDARD_LOAN,
        MONETARY_AUTO_LOAN,
        SIM_TOP_UP,
        SIM_TOP_UP_WITH_DATA_BONUS,
        SIM_TOP_UP_WITH_MONETARY_BONUS,
        ESIM,
        CARRIER_PLAN_PREPAID,
        CARRIER_PLAN_POSTPAID
    }

    enum PaymentType {
        CREDIT_CARD,
        DEBIT_CARD,
        MOBILE_WALLET,
        PIX,
        BANK_DEPOSIT,
        INVOICE,
        AIRTIME
    }

    @Getter
    enum ResultCode {
        SUCCESS(0),
        FAILURE(-1);

        private final int value;

        ResultCode(int value) {
            this.value = value;
        }

    }
}
