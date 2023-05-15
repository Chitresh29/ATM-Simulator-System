/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
public class SignupTwo extends JFrame implements ActionListener {
    JTextField pan,aadharno,stateTextField,pinTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,categoryopt,occupation,education,income;
    String formno;
    
    SignupTwo(String formno){
        this.formno =formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Railway",Font.BOLD,22));
        additionalDetails.setBounds(290,80, 400, 30);
        add(additionalDetails);
        
       JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(100,140, 100, 30);
        add(name);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Jain","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Railway",Font.BOLD,20));
        category.setBounds(100,190, 200, 30);
        add(category);
        
        String valcategory[]={"General","OBC","SC","ST","Other"};
        categoryopt=new JComboBox(valcategory);
        categoryopt.setBounds(300,190,400,30);
        categoryopt.setBackground(Color.WHITE);
        add(categoryopt);
        
        
        JLabel inc=new JLabel("Income:");
        inc.setFont(new Font("Railway",Font.BOLD,20));
        inc.setBounds(100,240, 200, 30);
        add(inc);
        
        String imcomecategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income=new JComboBox(imcomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        JLabel edu=new JLabel("Educational:");
        edu.setFont(new Font("Railway",Font.BOLD,20));
        edu.setBounds(100,290, 200, 30);
        add(edu);
        
        JLabel qc=new JLabel("Qualification:");
        qc.setFont(new Font("Railway",Font.BOLD,20));
        qc.setBounds(100,315, 200, 30);
        add(qc);
        
        String educationValue[]={"Non-Graduate","Graduate","Post-Graduation","Doctrate","Others"};
        education=new JComboBox(educationValue);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
             
        JLabel occ=new JLabel("Occupation:");
        occ.setFont(new Font("Railway",Font.BOLD,20));
        occ.setBounds(100,390, 200, 30);
        add(occ);
        
        String occupationValue[]={"Salaried","Self-Employed","BusinessMan","Student","Retired","Others"};
        occupation=new JComboBox(occupationValue);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel panno=new JLabel("Pan Number:");
        panno.setFont(new Font("Railway",Font.BOLD,20));
        panno.setBounds(100,440, 200, 30);
        add(panno);
        
        pan=new JTextField();
        pan.setFont(new Font("Railway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel aadhar=new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Railway",Font.BOLD,20));
        aadhar.setBounds(100,490, 200, 30);
        add(aadhar);
        
        aadharno=new JTextField();
        aadharno.setFont(new Font("Railway",Font.BOLD,14));
        aadharno.setBounds(300,490,400,30);
        add(aadharno);
        
        JLabel scitizen=new JLabel("Senior Citizen:");
        scitizen.setFont(new Font("Railway",Font.BOLD,20));
        scitizen.setBounds(100,540, 200, 30);
        add(scitizen);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,60,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(syes);
        gendergroup.add(sno);
        
        
        JLabel pincode=new JLabel("Exixting Account:");
        pincode.setFont(new Font("Railway",Font.BOLD,20));
        pincode.setBounds(100,590, 200, 30);
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,60,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)categoryopt.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        }else if(eno.isSelected()){
            existingaccount="No";
        }
        String span=pan.getText();
        String saadhar=aadharno.getText();
        
        try{
            Conn c=new Conn();
            String query= "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+seniorcitizen+"','"+existingaccount+"','"+span+"','"+saadhar+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }    
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        new SignupTwo("");
        
    }
    
}
