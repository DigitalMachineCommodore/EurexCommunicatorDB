package byteinspace.net.eurexcommunicatordb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import byteinspace.net.eurexcommunicatordb.R;
import byteinspace.net.eurexcommunicatordb.model.Invoice;

/**
 * Created by daniel on 27.02.2017.
 */

public class InvoiceService {

    private Map<Integer, Invoice> invoices = new HashMap<>();

    protected InvoiceService() {
        Invoice invoice1 = new Invoice();
        invoice1.setId(1);
        invoice1.setDatum("15.02.2017");
        invoice1.setTitle("Lease lines");
        invoice1.setPaid(false);
        invoice1.setAmount("234.00 EUR");
        invoice1.setDueTo("15.04.2017");
        invoice1.setImage(R.drawable.leaseline);
        invoices.put(invoice1.getId(), invoice1);

        Invoice invoice2 = new Invoice();
        invoice2.setId(2);
        invoice2.setDatum("15.01.2017");
        invoice2.setTitle("Ordering data");
        invoice2.setPaid(false);
        invoice2.setAmount("144.00 EUR");
        invoice2.setDueTo("15.04.2017");
        invoice2.setImage(R.drawable.orderingdata);
        invoices.put(invoice2.getId(), invoice2);

        Invoice invoice3 = new Invoice();
        invoice3.setId(3);
        invoice3.setTitle("Lease lines");
        invoice3.setDatum("15.12.2016");
        invoice3.setPaid(true);
        invoice3.setImage(R.drawable.leaseline);
        invoice3.setAmount("435.00 EUR");
        invoice3.setDueTo("15.04.2017");
        invoices.put(invoice3.getId(), invoice3);

        Invoice invoice4 = new Invoice();
        invoice4.setId(4);
        invoice4.setDatum("15.12.2016");
        invoice4.setTitle("Ordering data");
        invoice4.setPaid(true);
        invoice4.setAmount("98.00 USD");
        invoice4.setDueTo("15.04.2017");
        invoice4.setImage(R.drawable.orderingdata);
        invoices.put(invoice4.getId(), invoice4);

        Invoice invoice5 = new Invoice();
        invoice5.setId(5);
        invoice5.setTitle("Lease lines");
        invoice5.setDatum("15.12.2016");
        invoice5.setAmount("777.00 GBP");
        invoice5.setImage(R.drawable.leaseline);
        invoice5.setPaid(true);
        invoice5.setDueTo("15.04.2017");
        invoices.put(invoice5.getId(), invoice5);
    }

    public List<Invoice> getAllInvoices() {
        List<Invoice> listInvoices = new ArrayList<>();
        for (Invoice invoice : this.invoices.values()) {
            listInvoices.add(invoice);
        }
        return listInvoices;
    }
}
