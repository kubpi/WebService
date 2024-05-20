package org.example;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PdfGenerator {
    public static byte[] generateTicketPdf(Ticket ticket) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Add title
        document.add(new Paragraph("Flight Ticket").setFontSize(20).setBold());

        // Add passenger details
        document.add(new Paragraph("Passenger Details").setBold());
        Table passengerTable = new Table(UnitValue.createPercentArray(new float[]{1, 2}));
        passengerTable.addCell("Name:");
        passengerTable.addCell(ticket.getPassengerName());
        passengerTable.addCell("Email:");
        passengerTable.addCell(ticket.getPassengerEmail());
        passengerTable.addCell("Phone:");
        passengerTable.addCell(ticket.getPassengerPhone());
        document.add(passengerTable);

        // Add flight details
        document.add(new Paragraph("Flight Details").setBold());
        Table flightTable = new Table(UnitValue.createPercentArray(new float[]{1, 2}));
        flightTable.addCell("Flight Number:");
        flightTable.addCell(ticket.getFlightDetails().getFlightNumber());
        flightTable.addCell("From:");
        flightTable.addCell(ticket.getFlightDetails().getCityFrom());
        flightTable.addCell("To:");
        flightTable.addCell(ticket.getFlightDetails().getCityTo());
        flightTable.addCell("Day:");
        flightTable.addCell(ticket.getFlightDetails().getDay());
        flightTable.addCell("Time:");
        flightTable.addCell(ticket.getFlightDetails().getTime());
        document.add(flightTable);

        // Close the document
        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}
