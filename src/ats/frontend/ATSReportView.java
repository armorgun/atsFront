/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ats.frontend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author armor
 */
public class ATSReportView extends javax.swing.JFrame {

    /**
     * Creates new form ATSReportView
     */
    
    DBInter db = Login.db;
    int type=0; 
    String client=null;
    public ATSReportView(int t) {
        initComponents();
        type=t;
        
        
        
        if(type==0) //stockreport
        {
            int lastock=0;
            
            try {
                lastock = db.get1INT("SELECT lateststock FROM ats_sysdb.agencydetails")[0];
                for(int i=0;i<lastock;i++)
                {
                    long[] d = db.get1LONG("SELECT idblank FROM ats_sysdb.blank WHERE `idblank` LIKE \"___"+String.format("%04d", i)+"____\"");
                    int typ= (int) (d[0]/100000000);
                    int j=0;
                    while(d[j]!=0){j++;}
                    //db.get1LONG("SELECT idblank FROM ats_sysdb.blank WHERE `username`='0'");
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"Received : "+typ+" StockNo : "+String.format("%04d", i)+" Amount : "+j+" From : "+d[0]+" TO "+d[j-1]+" Date : "+db.get1String("SELECT date_received FROM ats_sysdb.blank")[0]);
                }
                jTextPane2.setText(jTextPane2.getText()+"\n");
                
                String[] users = db.get1String("SELECT username FROM ats_sysdb.staff WHERE type = 1");
                int j=0;
                while (users[j]!=null)
                {
                    int y=0;
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"\n"+"Assigned to advisor "+users[j]+" is:");
                    
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"Type 444 is: ");
                    for(int i=0;i<lastock;i++)
                    {
                        //System.out.println(i);
                        long[] d = db.get1LONG("SELECT idblank FROM ats_sysdb.blank WHERE `username` LIKE \""+users[j]+"\" AND `type` = 444 AND `idblank` LIKE \"___"+String.format("%04d", i)+"____\"");
                        
                        int x=0;
                        while(d[x]!=0)
                        {
                            
                            
                            if(d[x]+1!=d[x+1])
                            {
                                jTextPane2.setText(jTextPane2.getText()+d[y]+" TO "+d[x]+"   ");
                                y=x+1;
                            }
                               x++; 
                        }
                        
                            
                        
                        
                        
                    }
                    
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"Type 440 is: ");
                    for(int i=0;i<lastock;i++)
                    {
                        long[] d = db.get1LONG("SELECT idblank FROM ats_sysdb.blank WHERE `username` LIKE \""+users[j]+"\" AND `type` = 440 AND `idblank` LIKE \"___"+String.format("%04d", i)+"____\"");
                        
                        int x=0;
                        while(d[x]!=0){x++;}
                        if(x!=0)
                        jTextPane2.setText(jTextPane2.getText()+d[0]+" TO "+d[x-1]+"   ");
                        
                    }
                    
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"Type 420 is: ");
                    for(int i=0;i<lastock;i++)
                    {
                        long[] d = db.get1LONG("SELECT idblank FROM ats_sysdb.blank WHERE `username` LIKE \""+users[j]+"\" AND `type` = 420 AND `idblank` LIKE \"___"+String.format("%04d", i)+"____\"");
                        
                        int x=0;
                        while(d[x]!=0){x++;}
                        if(x!=0)
                        jTextPane2.setText(jTextPane2.getText()+d[0]+" TO "+d[x-1]+"   ");
                        
                    }
                    
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"Type 201 is: ");
                    for(int i=0;i<lastock;i++)
                    {
                        long[] d = db.get1LONG("SELECT idblank FROM ats_sysdb.blank WHERE `username` LIKE \""+users[j]+"\" AND `type` = 201 AND `idblank` LIKE \"___"+String.format("%04d", i)+"____\"");
                        
                        int x=0;
                        while(d[x]!=0){x++;}
                        if(x!=0)
                        jTextPane2.setText(jTextPane2.getText()+d[0]+" TO "+d[x-1]+"   ");
                        
                    }
                    
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"Type 101 is: ");
                    for(int i=0;i<lastock;i++)
                    {
                        long[] d = db.get1LONG("SELECT idblank FROM ats_sysdb.blank WHERE `username` LIKE \""+users[j]+"\" AND `type` = 101 AND `idblank` LIKE \"___"+String.format("%04d", i)+"____\"");
                        
                        int x=0;
                        while(d[x]!=0){x++;}
                        if(x!=0)
                        jTextPane2.setText(jTextPane2.getText()+d[0]+" TO "+d[x-1]+"   ");
                        
                    }
                    
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"Type 451 is: ");
                    for(int i=0;i<lastock;i++)
                    {
                        long[] d = db.get1LONG("SELECT idblank FROM ats_sysdb.blank WHERE `username` LIKE \""+users[j]+"\" AND `type` = 451 AND `idblank` LIKE \"___"+String.format("%04d", i)+"____\"");
                        
                        int x=0;
                        while(d[x]!=0){x++;}
                        if(x!=0)
                        jTextPane2.setText(jTextPane2.getText()+d[0]+" TO "+d[x-1]+"   ");
                        
                    }
                    
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"Type 452 is: ");
                    for(int i=0;i<lastock;i++)
                    {
                        long[] d = db.get1LONG("SELECT idblank FROM ats_sysdb.blank WHERE `username` LIKE \""+users[j]+"\" AND `type` = 452 AND `idblank` LIKE \"___"+String.format("%04d", i)+"____\"");
                        
                        int x=0;
                        while(d[x]!=0){x++;}
                        if(x!=0)
                        jTextPane2.setText(jTextPane2.getText()+d[0]+" TO "+d[x-1]+"   ");
                        
                    }
                    
                    
                    
                    
                    
                    j++;
                }
                
                long[] s = db.get1LONG("SELECT idblank FROM ats_sysdb.blank WHERE date_sold=0 AND void=1");
                int jj=0;
                do
                    {
                        if(s[jj]/10000!=s[jj+1]/10000)
                            jTextPane2.setText(jTextPane2.getText()+"\n"+"\n"+" Stock "+s[jj]/10000%10000+" Was removed ");
                        //System.out.println(s[jj]/10000);
                        jj++;
                    }while(s[jj]!=0);
                
                
                
                
                long[] d = db.get1LONG("SELECT idblank FROM ats_sysdb.blank WHERE date_sold!=0");
                String[] datee = db.get1String("SELECT date_sold FROM ats_sysdb.blank WHERE date_sold!=0");
                    int i=0;
                    while(d[i]!=0)
                    {
                        jTextPane2.setText(jTextPane2.getText()+"\n"+"\n"+d[i]+" Was sold on "+datee[i]);
                        
                        i++;
                    }
                
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ATSReportView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(type==1)   //Individual domestic
        {
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                LocalDateTime localDate = LocalDateTime.now();
                
                int staffId = db.get1INT("SELECT idstaff FROM ats_sysdb.staff WHERE username = '"+MainGUI.userName+"'")[0];
                long[] trans = db.get1LONG("SELECT idtransaction FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 0");
                String[] date = db.get1String("SELECT date FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 0");
                float[] price = db.get1FLOAT("SELECT amount FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 0");
                float[] paid = db.get1FLOAT("SELECT paid FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 0");
                String[] method = db.get1String("SELECT method FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 0");
                long[] idcard = db.get1LONG("SELECT idcard FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 0");
                long[] currency = db.get1LONG("SELECT currency FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 0");
                float[] exr = db.get1FLOAT("SELECT exchange_rate FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 0");
                float[] commi = db.get1FLOAT("SELECT commission FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 0");
                int i=0; float total=0,comm=0;
                jTextPane2.setText(jTextPane2.getText()+"Individual Domestic sales report: Date "+dtf.format(localDate)+"\n"+"Advisor "+MainGUI.userName+" of ID : "+staffId+" has sold:"+"\n");
                while(trans[i]!=0)
                {
                    total=total+paid[i]; comm=comm+(paid[i]*commi[i]/100);
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"  "+(i+1)+"  "+trans[i]+" on the date of "+date[i]+" Cost: "+price[i]+" Paid: "+paid[i]);
                    if("Card".equals(method[i]))
                        jTextPane2.setText(jTextPane2.getText()+" With Card: "+idcard[i]);
                    else
                        jTextPane2.setText(jTextPane2.getText()+" By Cash");
                    if(currency[i]==1)
                        jTextPane2.setText(jTextPane2.getText()+" In USD, amount converted to Local Currency with conversion rate "+exr[i]);
                    else
                        jTextPane2.setText(jTextPane2.getText()+" In Local Currency");
                    if(paid[i]>price[i] && price[i]==0)
                        jTextPane2.setText(jTextPane2.getText()+"    REFUNDED");
                    
                    i++;
                }
                jTextPane2.setText(jTextPane2.getText()+"\n"+"\n"+"Total Amount Paid: "+total+" From Which "+comm+" Is Commission.");
                
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ATSReportView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else if(type==2)   //Individual interline
        {
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                LocalDateTime localDate = LocalDateTime.now();
                
                int staffId = db.get1INT("SELECT idstaff FROM ats_sysdb.staff WHERE username = '"+MainGUI.userName+"'")[0];
                long[] trans = db.get1LONG("SELECT idtransaction FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 1");
                String[] date = db.get1String("SELECT date FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 1");
                float[] price = db.get1FLOAT("SELECT amount FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 1");
                float[] paid = db.get1FLOAT("SELECT paid FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 1");
                String[] method = db.get1String("SELECT method FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 1");
                long[] idcard = db.get1LONG("SELECT idcard FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 1");
                long[] currency = db.get1LONG("SELECT currency FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 1");
                float[] exr = db.get1FLOAT("SELECT exchange_rate FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 1");
                float[] commi = db.get1FLOAT("SELECT commission FROM ats_sysdb.transaction WHERE idstaff = '"+MainGUI.userName+"' AND interline = 1");
                int i=0; float total=0,comm=0;
                jTextPane2.setText(jTextPane2.getText()+"Individual Domestic sales report: Date "+dtf.format(localDate)+"\n"+"Advisor "+MainGUI.userName+" of ID : "+staffId+" has sold:"+"\n");
                while(trans[i]!=0)
                {
                    total=total+paid[i]; comm=comm+(paid[i]*commi[i]/100);
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"  "+(i+1)+"  "+trans[i]+" on the date of "+date[i]+" Cost: "+price[i]+" Paid: "+paid[i]);
                    if("Card".equals(method[i]))
                        jTextPane2.setText(jTextPane2.getText()+" With Card: "+idcard[i]);
                    else
                        jTextPane2.setText(jTextPane2.getText()+" By Cash");
                    if(currency[i]==1)
                        jTextPane2.setText(jTextPane2.getText()+" In USD, amount converted to Local Currency with conversion rate "+exr[i]);
                    else
                        jTextPane2.setText(jTextPane2.getText()+" In Local Currency");
                    if(paid[i]>price[i] && price[i]==0)
                        jTextPane2.setText(jTextPane2.getText()+"    REFUNDED");
                    
                    i++;
                }
                jTextPane2.setText(jTextPane2.getText()+"\n"+"\n"+"Total Amount Paid: "+total+" From Which "+comm+" Is Commission.");
                
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ATSReportView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else if(type==3)   //Global domestic
        {
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    LocalDateTime localDate = LocalDateTime.now();
                
                int[] staffId = db.get1INT("SELECT idstaff FROM ats_sysdb.staff WHERE type = 1;");
                String[] staffId2 = db.get1String("SELECT username FROM ats_sysdb.staff WHERE type = 1");
                
                float total2=0,comm2=0,tot2=0;
                
                
                int i=0;
                jTextPane2.setText(jTextPane2.getText()+"Global Domestic sales report: Date "+dtf.format(localDate)+"\n"+"ATS"+"\n");
                while(staffId[i]!=0)
                {
                    
                    
                    
                    
                    long[] trans = db.get1LONG("SELECT idtransaction FROM ats_sysdb.transaction WHERE idstaff = '"+staffId2[i]+"' AND interline = 0");
                   
                    float[] price = db.get1FLOAT("SELECT amount FROM ats_sysdb.transaction WHERE idstaff = '"+staffId2[i]+"' AND interline = 0");
                    float[] paid = db.get1FLOAT("SELECT paid FROM ats_sysdb.transaction WHERE idstaff = '"+staffId2[i]+"' AND interline = 0");
                    
                    //float[] exr = db.get1FLOAT("SELECT exchange_rate FROM ats_sysdb.transaction WHERE idstaff = '"+staffId2[i]+"' AND interline = 0");
                    float[] commi = db.get1FLOAT("SELECT commission FROM ats_sysdb.transaction WHERE idstaff = '"+staffId2[i]+"' AND interline = 0");
                    int j=0; float total=0,comm=0,tot=0;
                    
                    while(trans[j]!=0)
                    {
                        
                        tot=tot+price[j];
                        total=total+paid[j]; 
                        comm=comm+(paid[j]*commi[j]/100);
                        
                        
                        
                        j++; //number of transactions peradvisor
                    }
                    
                    tot2=tot2+tot;
                        total2=total2+total; 
                        comm2=comm2+comm;
                    
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"    "+(i+1)+". Advisor "+staffId2[i]+" has sold "+j+" Tickets of value: "+tot+" from which "+total+" was paid. "+comm+" is commison from the total paid amount");
                    
                    i++;
                    
                }
                jTextPane2.setText(jTextPane2.getText()+"\n"+"\n"+"Total: "+tot2+" From Which: Amount Paid: "+total2+" From Which "+comm2+" Is Commission.");
                
            } catch (SQLException ex) {
                Logger.getLogger(ATSReportView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(type==4)   //Global interline
        {
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    LocalDateTime localDate = LocalDateTime.now();
                
                int[] staffId = db.get1INT("SELECT idstaff FROM ats_sysdb.staff WHERE type = 1;");
                String[] staffId2 = db.get1String("SELECT username FROM ats_sysdb.staff WHERE type = 1");
                
                float total2=0,comm2=0,tot2=0;
                
                
                int i=0;
                jTextPane2.setText(jTextPane2.getText()+"Global Interline sales report: Date "+dtf.format(localDate)+"\n"+"ATS"+"\n");
                while(staffId[i]!=0)
                {
                    
                    
                    
                    
                    long[] trans = db.get1LONG("SELECT idtransaction FROM ats_sysdb.transaction WHERE idstaff = '"+staffId2[i]+"' AND interline = 1");
                   
                    float[] price = db.get1FLOAT("SELECT amount FROM ats_sysdb.transaction WHERE idstaff = '"+staffId2[i]+"' AND interline = 1");
                    float[] paid = db.get1FLOAT("SELECT paid FROM ats_sysdb.transaction WHERE idstaff = '"+staffId2[i]+"' AND interline = 1");
                    
                    //float[] exr = db.get1FLOAT("SELECT exchange_rate FROM ats_sysdb.transaction WHERE idstaff = '"+staffId2[i]+"' AND interline = 1");
                    float[] commi = db.get1FLOAT("SELECT commission FROM ats_sysdb.transaction WHERE idstaff = '"+staffId2[i]+"' AND interline = 1");
                    int j=0; float total=0,comm=0,tot=0;
                    
                    while(trans[j]!=0)
                    {
                        
                        tot=tot+price[j];
                        total=total+paid[j]; 
                        comm=comm+(paid[j]*commi[j]/100);
                        
                        
                        
                        j++; //number of transactions peradvisor
                    }
                    
                    tot2=tot2+tot;
                        total2=total2+total; 
                        comm2=comm2+comm;
                    
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"    "+(i+1)+". Advisor "+staffId2[i]+" has sold "+j+" Tickets of value: "+tot+" from which "+total+" was paid. "+comm+" is commison from the total paid amount");
                    
                    i++;
                    
                }
                jTextPane2.setText(jTextPane2.getText()+"\n"+"\n"+"Total: "+tot2+" From Which: Amount Paid: "+total2+" From Which "+comm2+" Is Commission.");
                
            } catch (SQLException ex) {
                Logger.getLogger(ATSReportView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else if(type==5)   //Per USD Global
        {
            
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    LocalDateTime localDate = LocalDateTime.now();
                
                ArrayList<Float> exRates= new ArrayList<>();
                ArrayList<Float> tot= new ArrayList<>();
                ArrayList<Float> total= new ArrayList<>();
                ArrayList<Float> commis= new ArrayList<>();
                ArrayList<Integer> tick= new ArrayList<>();
                long[] trans = db.get1LONG("SELECT idtransaction FROM ats_sysdb.transaction WHERE currency = 1");
                float[] exr = db.get1FLOAT("SELECT exchange_rate FROM ats_sysdb.transaction WHERE currency = 1");
                float[] price = db.get1FLOAT("SELECT amount FROM ats_sysdb.transaction  WHERE currency = 1");
                float[] paid = db.get1FLOAT("SELECT paid FROM ats_sysdb.transaction  WHERE currency = 1");
                float[] comm = db.get1FLOAT("SELECT commission FROM ats_sysdb.transaction  WHERE currency = 1");
                
                
                jTextPane2.setText(jTextPane2.getText()+"Global per exchange rate sales report: Date "+dtf.format(localDate)+"\n"+"ATS"+"\n");
                int i=0;
                
                exRates.add(exr[i]);
                tot.add( paid[i]);
                total.add( price[i]);
                commis.add(comm[i]);
                tick.add(1);
                //System.out.println("Added new curr");
                i++;
                
                while(trans[i]!=0)
                {
                    //System.out.println("Loop "+i);
                    
                            
                    int j = 0;
                    for (j = 0; j < exRates.size(); j++) {
                        //System.out.println("Loop x "+j);
                        
                        if (exRates.get(j).compareTo(exr[i])==0) 
                        {
                            tot.set(j, tot.get(j)+paid[i]);
                            total.set(j, total.get(j)+price[i]);
                            commis.set(j, commis.get(j)+comm[i]);
                            tick.set(j, tick.get(j)+1);
                            //System.out.println("edited curr");
                            break;
                        }else if(j+1==exRates.size())
                        {
                            exRates.add(exr[i]);
                            tot.add( paid[i]);
                            total.add( price[i]);
                            commis.add(comm[i]);
                            tick.add(1);
                            //System.out.println("Added new curr");
                            break;
                            
                        }
                    }
                    i++;
                }
                float total2=0,tot2=0,com=0; int ti=0;
                for (int j = 0; j < exRates.size(); j++) 
                {
                    System.out.println(exRates.get(j));
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"For rate "+exRates.get(j)+" There were "+tick.get(j)+" Tickets sold for a Total of "+total.get(j)+" was sold from which "+tot.get(j)+" was paid from which "+commis.get(j)+" is commission.");
                    total2=total2+total.get(j);
                    tot2=tot2+tot.get(j);
                    com=com+commis.get(j);
                    ti=ti+tick.get(j);
                    
                    
                }
                
                
                
                
                jTextPane2.setText(jTextPane2.getText()+"\n"+"\n"+"Total of "+ti+" tickets were sold for the value: "+total2+" from which "+tot2+" was paid from which "+com+" was commission.");
                
            } catch (SQLException ex) {
                Logger.getLogger(ATSReportView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public ATSReportView(int t, String cl) {
        initComponents();
        this.type=t;
        this.client =cl;
        
        
        
        //Client Report
        
            try {
                
                
                String pno = db.get1String("SELECT passportno FROM ats_sysdb.customer WHERE firstname LIKE \"%"+client+"%\" OR lastname LIKE \"%"+client+"%\"")[0];
                String cs = db.get1String("SELECT lastname FROM ats_sysdb.customer WHERE firstname LIKE \"%"+client+"%\" OR lastname LIKE \"%"+client+"%\"")[0];
                String cll = db.get1String("SELECT firstname FROM ats_sysdb.customer WHERE firstname LIKE \"%"+client+"%\" OR lastname LIKE \"%"+client+"%\"")[0];
                jTextPane2.setText(jTextPane2.getText()+"Report for customer "+cll+" "+cs+"\n"+"\n");
                
                long[] trid = db.get1LONG("SELECT idtransaction FROM ats_sysdb.transaction WHERE idcustomer = '"+pno+"'");
                String[] date = db.get1String("SELECT date FROM ats_sysdb.transaction WHERE idcustomer = '"+pno+"'");
                float[] price = db.get1FLOAT("SELECT amount FROM ats_sysdb.transaction WHERE idcustomer = '"+pno+"'");
                float[] paid = db.get1FLOAT("SELECT paid FROM ats_sysdb.transaction WHERE idcustomer = '"+pno+"'");
                String[] method = db.get1String("SELECT method FROM ats_sysdb.transaction WHERE idcustomer = '"+pno+"'");
                long[] idcard = db.get1LONG("SELECT idcard FROM ats_sysdb.transaction WHERE idcustomer = '"+pno+"'");
                int[] currency = db.get1INT("SELECT currency FROM ats_sysdb.transaction WHERE idcustomer = '"+pno+"'");
                float[] exr = db.get1FLOAT("SELECT exchange_rate FROM ats_sysdb.transaction WHERE idcustomer = '"+pno+"'");
                //float[] commi = db.get1FLOAT("SELECT commission FROM ats_sysdb.transaction WHERE idcustomer = '"+pno+"'");
                
                int i=0; float total=0,paidd=0,retu=0;
                if(trid[0]!=0)
                while(trid[i]!=0)
                {
                    if(price[i]==0)
                        jTextPane2.setText(jTextPane2.getText()+"\n"+"*-Refunded "+"\n");
                    else
                        jTextPane2.setText(jTextPane2.getText()+"\n"+"-Sold "+"\n");
                    jTextPane2.setText(jTextPane2.getText()+"     "+trid[i]+" on "+date[i]+" Amount: "+price[i]+" Paid: "+paid[i]+" Using: "+method[i]);
                    if("Card".equals(method[i]))
                        jTextPane2.setText(jTextPane2.getText()+" of id "+idcard[i]+"");
                    
                    if(currency[i]==1)
                        jTextPane2.setText(jTextPane2.getText()+" In USD, amount converted to Local Currency with conversion rate "+exr[i]+"");
                    else
                        jTextPane2.setText(jTextPane2.getText()+" In Local Currency");
                    
                    if(paid[i]>price[i] && price[i]==0)
                        retu=retu+paid[i];
                    
                    total=total+price[i];
                    paidd=paidd+paid[i];
                    i++;
                }
                else {jTextPane2.setText(jTextPane2.getText()+" No Transactions");}
                
                jTextPane2.setText(jTextPane2.getText()+"\n"+"\n"+"Total: "+total+" from which "+paidd+" was paid.");
                
                if(retu!=0)
                    jTextPane2.setText(jTextPane2.getText()+"\n"+"\n"+"Amount to be returned to customer  "+cll+" "+cs+": "+retu);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ATSReportView.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    
    
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lowerPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATS Report Viewer");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));

        lowerPanel.setBackground(new java.awt.Color(51, 51, 51));
        lowerPanel.setForeground(new java.awt.Color(102, 102, 102));

        saveButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lowerPanelLayout = new javax.swing.GroupLayout(lowerPanel);
        lowerPanel.setLayout(lowerPanelLayout);
        lowerPanelLayout.setHorizontalGroup(
            lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lowerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1091, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addContainerGap())
        );
        lowerPanelLayout.setVerticalGroup(
            lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lowerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        jTextPane2.setBackground(new java.awt.Color(0, 0, 0));
        jTextPane2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jTextPane2.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyHHmm");
            LocalDateTime localDate = LocalDateTime.now();
        
        try{
            
            
            
            switch (type) {
                case 0:
                    {
                        PrintWriter writer = new PrintWriter("StockReport"+dtf.format(localDate)+".txt", "UTF-8");
                        writer.print(jTextPane2.getText());
                        writer.close();
                        break;
                    }
                case 1:
                    {
                        int staffId = db.get1INT("SELECT idstaff FROM ats_sysdb.staff WHERE username = '"+MainGUI.userName+"'")[0];
                        PrintWriter writer = new PrintWriter("IDomestic_"+staffId+"_"+dtf.format(localDate)+".txt", "UTF-8");
                        writer.print(jTextPane2.getText());
                        writer.close();
                        break;
                    }
                case 2:
                    {
                        int staffId = db.get1INT("SELECT idstaff FROM ats_sysdb.staff WHERE username = '"+MainGUI.userName+"'")[0];
                        PrintWriter writer = new PrintWriter("IInterline_"+staffId+"_"+dtf.format(localDate)+".txt", "UTF-8");
                        writer.print(jTextPane2.getText());
                        writer.close();
                        break;
                    }
                case 3:
                    {
                        PrintWriter writer = new PrintWriter("GDomestic"+dtf.format(localDate)+".txt", "UTF-8");
                        writer.print(jTextPane2.getText());
                        writer.close();
                        break;
                    }
                case 4:
                    {
                        PrintWriter writer = new PrintWriter("GInterline"+dtf.format(localDate)+".txt", "UTF-8");
                        writer.print(jTextPane2.getText());
                        writer.close();
                        break;
                    }
                case 5:
                    {
                        PrintWriter writer = new PrintWriter("GUSD"+dtf.format(localDate)+".txt", "UTF-8");
                        writer.print(jTextPane2.getText());
                        writer.close();
                        break;
                    }
                case 6:
                    {
                        String pno = db.get1String("SELECT passportno FROM ats_sysdb.customer WHERE firstname LIKE \"%"+client+"%\" OR lastname LIKE \"%"+client+"%\"")[0];
                        PrintWriter writer = new PrintWriter("ClientReport_"+pno+"_"+dtf.format(localDate)+".txt", "UTF-8");
                        writer.print(jTextPane2.getText());
                        writer.close();
                        break;
                    }
                default:
                    break;
            }
    
    
        } catch (IOException e) {
            // do something
        }       
        catch (SQLException ex) {
            Logger.getLogger(ATSReportView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JPanel lowerPanel;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables






}
