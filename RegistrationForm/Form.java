package RegistrationForm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

public class Form extends JFrame implements ActionListener {
    JLabel lTitle,lId,lName,lEmail,lHobbies,lCountry,lGender,status;
    JTextField tId,tName,tEmail;
    JCheckBox cycling,gaming,reading,travel;
    JComboBox<String> countries;
    ButtonGroup btnGroup;
    JRadioButton male,female;
    JButton clear,update,delete,save;
    public Form(){
        this.setTitle("Registration Form");
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(1000,600);
        Color backColor=new Color(180,250,220);
        Container contentPane=this.getContentPane();
        contentPane.setBackground(backColor);

        Font titleFont=new Font("Arial",Font.BOLD,40);
        Font labelFont=new Font("Georgia",Font.PLAIN,30);
        Font txtFont=new Font("Calibri",Font.PLAIN,25);
        Font comboFont=new Font("Verdana",Font.PLAIN,18);
        Font hobbiesFont=new Font("Garamond",Font.ROMAN_BASELINE,18);
        Font genderFont=new Font("Garamond",Font.ROMAN_BASELINE,18);
        Font btnFont=new Font("Tahoma",Font.PLAIN,25);
        Font statusFont=new Font("Helvetica",Font.ITALIC,19);

        lTitle =new JLabel("Registration");
        lTitle.setBounds(400,30,250,43);
        lTitle.setFont(titleFont);
        lTitle.setForeground(Color.RED);

        lId=new JLabel("ID");
        lId.setBounds(250,100,100,30);
        lId.setFont(labelFont);
        lId.setForeground(Color.BLUE);

        lName=new JLabel("Name");
        lName.setBounds(250,150,100,30);
        lName.setFont(labelFont);
        lName.setForeground(Color.BLUE);

        lEmail=new JLabel("Email");
        lEmail.setBounds(250,200,100,30);
        lEmail.setFont(labelFont);
        lEmail.setForeground(Color.BLUE);

        lHobbies=new JLabel("Hobbies");
        lHobbies.setBounds(250,250,150,30);
        lHobbies.setFont(labelFont);
        lHobbies.setForeground(Color.BLUE);

        lCountry=new JLabel("Country");
        lCountry.setBounds(250,300,150,30);
        lCountry.setFont(labelFont);
        lCountry.setForeground(Color.BLUE);

        lGender=new JLabel("Gender");
        lGender.setBounds(250,350,150,30);
        lGender.setFont(labelFont);
        lGender.setForeground(Color.BLUE);

        tId=new JTextField("");
        tId.setBounds(400,100,350,33);
        tId.setFont(txtFont);
        tId.setForeground(Color.BLACK);

        tName=new JTextField("");
        tName.setBounds(400,150,350,33);
        tName.setFont(txtFont);
        tName.setForeground(Color.BLACK);

        tEmail=new JTextField("");
        tEmail.setBounds(400,200,350,33);
        tEmail.setFont(txtFont);
        tEmail.setForeground(Color.BLACK);

        cycling=new JCheckBox("Cycling");
        cycling.setBounds(400,250,80,30);
        cycling.setFont(hobbiesFont);
        cycling.setForeground(Color.MAGENTA);

        gaming=new JCheckBox("Gaming");
        gaming.setBounds(500,250,80,30);
        gaming.setFont(hobbiesFont);
        gaming.setForeground(Color.MAGENTA);

        reading=new JCheckBox("Reading");
        reading.setBounds(600,250,85,30);
        reading.setFont(hobbiesFont);
        reading.setForeground(Color.MAGENTA);

        travel=new JCheckBox("Travel");
        travel.setBounds(700,250,80,30);
        travel.setFont(hobbiesFont);
        travel.setForeground(Color.MAGENTA);

        String [] c={"India","China","Germany","Dubai","USA","Canada"};

        countries=new JComboBox<>(c);
        countries.setBounds(400,300,200,30);
        countries.setFont(comboFont);
        countries.setForeground(Color.MAGENTA);

        male=new JRadioButton("Male");
        male.setBounds(400,350,80,30);
        male.setFont(genderFont);
        male.setForeground(Color.MAGENTA);

        female=new JRadioButton("Female");
        female.setBounds(480,350,80,30);
        female.setFont(genderFont);
        female.setForeground(Color.MAGENTA);

        btnGroup=new ButtonGroup();
        btnGroup.add(male);
        btnGroup.add(female);

        clear=new JButton("Clear");
        clear.setBounds(250,430,100,30);
        clear.setFont(btnFont);
        clear.setForeground(Color.YELLOW);

        update=new JButton("Update");
        update.setBounds(365,430,120,30);
        update.setFont(btnFont);
        update.setForeground(Color.BLUE);

        delete=new JButton("Delete");
        delete.setBounds(500,430,120,30);
        delete.setFont(btnFont);
        delete.setForeground(Color.RED);

        save=new JButton("Save");
        save.setBounds(640,430,100,30);
        save.setFont(btnFont);
        save.setForeground(Color.GREEN);

        status=new JLabel("");
        status.setBounds(250,480,250,30);
        status.setFont(statusFont);
        status.setForeground(Color.GREEN);

        add(lTitle);
        add(lId);
        add(lName);
        add(lEmail);
        add(lHobbies);
        add(lCountry);
        add(lGender);
        add(tId);
        add(tName);
        add(tEmail);
        add(cycling);
        add(gaming);
        add(reading);
        add(travel);
        add(countries);
        add(male);
        add(female);
        add(clear);
        add(update);
        add(delete);
        add(save);
        add(status);

        clear.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        save.addActionListener(this);
        tId.addActionListener(this);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void setClear(){
        tName.setText("");
        tId.setText("");
        tEmail.setText("");
        cycling.setSelected(false);
        gaming.setSelected(false);
        reading.setSelected(false);
        travel.setSelected(false);
        btnGroup.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String sId=tId.getText();
            int id=Integer.parseInt(sId);
            String name=tName.getText();
            String email=tEmail.getText();
            String selectedHobbies="";

            if (cycling.isSelected()){
                selectedHobbies=cycling.getText();
            }
            else if(gaming.isSelected()){
                selectedHobbies=gaming.getText();
            }
            else if(reading.isSelected()){
                selectedHobbies=reading.getText();
            }
            else if(travel.isSelected()){
                selectedHobbies=travel.getText();
            }

            String selectedCountry=(String) countries.getSelectedItem();

            String gender="";
            if(male.isSelected()){
                gender=male.getText();
            }
            else if(female.isSelected()){
                gender=female.getText();
            }

            //To access a Class using a Data Accessing Object(Form DAO)
            FormDAO deo=new FormDAO();

            if(e.getSource().equals(tId)){
                ResultSet result=deo.getDisplay(id);

                if (result.next()){
                    tId.setText(result.getString("ID"));
                    tName.setText(result.getString("NAME"));
                    tEmail.setText(result.getString("EMAIL"));
                    String hobby=result.getString("HOBBIES");
                    switch (hobby){
                        case "Cycling"->
                            cycling.setSelected(true);
                        case "Gamming"->
                            gaming.setSelected(true);
                        case "Reading"->
                            reading.setSelected(true);
                        case "Travel"->
                            travel.setSelected(true);
                    }
                    countries.setSelectedItem(result.getString("COUNTRY"));

                    String retrievedGender=result.getString("GENDER");
                    if(retrievedGender.equals("Male")){
                        male.setSelected(true);
                    }
                    else{
                        female.setSelected(true);
                    }
                }
                else{
                    setClear();
                    status.setText("Ivalid ID");
                }
            }

            if(e.getSource().equals(clear)){
                setClear();
                status.setText("Cleared");
            }
            else if(e.getSource().equals(update)){
               deo.getUpdate(id,name,email,selectedHobbies,selectedCountry,gender);
               status.setText("Successfully Updated");
               setClear();
            }
            else if(e.getSource().equals(delete)){
                deo.getDelete(id);
                status.setText("Successfully Deleted");
                setClear();
            }
            else if(e.getSource().equals(save)){
                deo.getSave(id,name,email,selectedHobbies,selectedCountry,gender);
                status.setText("Successfully Saved");
                setClear();
            }
        }
        catch (Exception ex){
            ex.fillInStackTrace();
        }
    }
}
