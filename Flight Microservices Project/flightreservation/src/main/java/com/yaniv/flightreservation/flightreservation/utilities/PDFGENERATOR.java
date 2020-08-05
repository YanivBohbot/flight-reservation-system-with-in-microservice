package com.yaniv.flightreservation.flightreservation.utilities;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.yaniv.flightreservation.flightreservation.entities.Reservation;
import org.springframework.stereotype.Component;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Component
public class PDFGENERATOR {

    public void generateItenary(Reservation reservation,String filePath)  {

        Document document = new Document();

        try{

            PdfWriter.getInstance(document , new FileOutputStream(filePath));
            document.open();
            document.add(generateTable(reservation));
            document.close();


        }catch (DocumentException | FileNotFoundException e ){
            e.printStackTrace();
        }
    }

    private PdfPTable generateTable(Reservation reservation)
    {
        PdfPTable table = new PdfPTable(2);

        PdfPCell cell;

        cell = new PdfPCell(new Phrase("Flight Itinerary"));
        cell.setColspan(2);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Flight Details"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("AirLines ");
        table.addCell(reservation.getFlight().getOperatingAirlines());

        table.addCell("DEparture City");
        table.addCell(reservation.getFlight().getDepartureCity());

        table.addCell("Arrival City");
        table.addCell(reservation.getFlight().getArrivalCity());

        table.addCell("Flight number");
        table.addCell(reservation.getFlight().getFlightNumber());

        table.addCell("DEparture City");
        table.addCell(reservation.getFlight().getDepartureCity());

        table.addCell("Departure Time");
        table.addCell(reservation.getFlight().getEstimatedDepartures().toString());




        cell = new PdfPCell(new Phrase("Passenger Details"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("First name");
        table.addCell(reservation.getPassenger().getFirstname());

        table.addCell("Last name ");
        table.addCell(reservation.getPassenger().getLastname());

        table.addCell("email");
        table.addCell(reservation.getPassenger().getEmail());

        table.addCell("Phone");
        table.addCell(reservation.getPassenger().getPhone());

        return table;
    }





}
