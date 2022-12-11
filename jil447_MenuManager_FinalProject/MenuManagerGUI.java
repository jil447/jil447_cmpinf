package jil447_MenuManager_FinalProject;
/**
 * Class MenuManagerGUI
 * @author:Jin Li
 * @created:12/2/2022
 */
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class MenuManagerGUI {
    //Properties
    private JFrame mainFrame;
    private JPanel BYOPanel;
    private JPanel genMenuPanel;
    private JPanel CRTDPanel;

    //Labels
    private JLabel entreeLabel;
    private JLabel sideLabel;
    private JLabel saladLabel;
    private JLabel dessertLabel;

    private JLabel createdMenuLabel;

    //ComboBox
    private JComboBox<String> entreeComboBox;
    private JComboBox<String> sideComboBox;
    private JComboBox<String> saladComboBox;
    private JComboBox<String> dessertComboBox;

    //JButton
    private JButton CRTMenuBtn;
    private JButton genRandomBtn;
    private JButton genMinCalBtn;
    private JButton genMaxCalBtn;

    //JButton
    private JButton detailsBtn;
    private JButton deleteAllBtn;
    private JButton saveBtn;

    //JList
    private JList<String> CRTDMenuList;
    private DefaultListModel<String> CRTDMenuListModel;

    GridBagConstraints c;

    Menumanager menuManager;

    public MenuManagerGUI(){
        menus = new ArrayList<>();
        menuManager= new Menumanager("data/dishes");
        initGUI();
        basicMainFrameSettings();
    }

    private void initGUI(){
        mainFrame = new JFrame();
        
        BYOPanel = new JPanel(new GridBagLayout());
        entreeLabel = new JLabel("Entree");
        sideLabel = new JLabel("Side");
        saladLabel = new JLabel("Salad");
        dessertLabel = new JLabel("Dessert");
        entreeComboBox = new JComboBox<>();
        sideComboBox = new JComboBox<>();
        saladComboBox = new JComboBox<>();
        dessertComboBox = new JComboBox<>();
        CRTMenuBtn = new JButton("Create Menu with these dishes");
        
        genMenuPanel = new JPanel(new GridBagLayout());
        genRandomBtn = new JButton("Generate a Random Menu");
        genMinCalBtn = new JButton("Generate a Minimum Calories Menu");
        genMaxCalBtn = new JButton("Generate a Maximum Calories Menu");
        
        CRTDPanel = new JPanel(new GridBagLayout());
        createdMenuLabel = new JLabel("Created Menus:");
        this.CRTDMenuListModel
                = new DefaultListModel<>();

        CRTDMenuList = new JList<>(CRTDMenuListModel);
        detailsBtn = new JButton("Details");
        deleteAllBtn = new JButton("Delete all");
        saveBtn = new JButton("Save to file");

        
        addActionListeners();
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        setGBC(0,0);
        c.insets = new Insets(7,5,0,5);
        BYOPanel.add(entreeLabel, c);

        setGBC(1,0);
        for (int i = 0; i < this.menuManager.getEntrees().size(); i++) {
            entreeComboBox.addItem(this.menuManager.getEntrees().get(i).getName());
        }
        BYOPanel.add(entreeComboBox, c);

        setGBC(0,1);
        BYOPanel.add(sideLabel, c);

        setGBC(1,1);
        for (int i = 0; i < this.menuManager.getSides().size(); i++) {
            sideComboBox.addItem(this.menuManager.getSides().get(i).getName());
        }
        BYOPanel.add(sideComboBox, c);

        setGBC(0,2);
        BYOPanel.add(saladLabel, c);

        setGBC(1,2);
        for (int i = 0; i < this.menuManager.getSalads().size(); i++) {
            saladComboBox.addItem(this.menuManager.getSalads().get(i).getName());
        }
        BYOPanel.add(saladComboBox, c);

        setGBC(0,3);
        BYOPanel.add(dessertLabel, c);

        setGBC(1,3);
        for (int i = 0; i < this.menuManager.getDesserts().size(); i++) {
            dessertComboBox.addItem(this.menuManager.getDesserts().get(i).getName());
        }
        BYOPanel.add(dessertComboBox, c);
        c.gridwidth = 2;
        setGBC(0,4);
        c.insets = new Insets(15,5,10,5);
        BYOPanel.add(CRTMenuBtn,c);


       Border title = BorderFactory.createTitledBorder(
               BorderFactory.createLineBorder(Color.BLACK,2) , "Build your own Menu");

        BYOPanel.setBorder(title);

        setGBC(0,0);
        genMenuPanel.add(genRandomBtn,c);
        setGBC(0,1);
        genMenuPanel.add(genMinCalBtn,c);
        setGBC(0,2);
        genMenuPanel.add(genMaxCalBtn,c);


        title = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK,2) , "Or generate a Menu");

        genMenuPanel.setBorder(title);
      
        //Created Menus' Components.
        GridBagConstraints con = new GridBagConstraints();
        con.gridwidth = 3;
        con.gridx = 0;
        con.gridy = 0;
        con.anchor = GridBagConstraints.WEST;
        con.insets = new Insets(5,0,2,0);
        CRTDPanel.add(createdMenuLabel,con);
        con.gridwidth = 3;
        con.gridx = 0;
        con.gridy = 1;
        CRTDMenuList.setPreferredSize(new Dimension(260,350));
        CRTDMenuList.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        CRTDPanel.add(CRTDMenuList,con);
        con.gridwidth = 1;
        con.gridx = 0;
        con.gridy = 2;
        con.insets = new Insets(10,0,20,2);
        CRTDPanel.add(detailsBtn,con);
        con.gridx = 1;
        con.gridy = 2;
        CRTDPanel.add(deleteAllBtn,con);
        con.gridx = 2;
        con.gridy = 2;

        CRTDPanel.add(saveBtn,con);
    }
    private void basicMainFrameSettings(){


        mainFrame.setLayout(new GridBagLayout());

        c.gridwidth = 1;
        setGBC(0,0);
        c.insets = new Insets(7,10,0,0);
        mainFrame.add(BYOPanel,c);
        setGBC(0,1);
        c.insets = new Insets(7,10,20,0);
        mainFrame.add(genMenuPanel,c);
        setGBC(3,0);
        c.gridheight = 2;
        c.insets = new Insets(2,20,0,10);
        mainFrame.add(CRTDPanel,c);

        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
       
        mainFrame.pack();
        mainFrame.setTitle("Menu Manager");
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setBounds(((screen.width - mainFrame.getWidth()) / 2), ((screen.height - mainFrame.getHeight()) / 2), mainFrame.getWidth(), mainFrame.getHeight());

    }
    private void setGBC(int x,int y){
        c.gridx = x;
        c.gridy = y;
    }

    ArrayList<Menu> menus;
    private void addActionListeners(){
        CRTMenuBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFrame inputFrame = new JFrame();
                GridLayout inputFrameLayout = new GridLayout(3,1);
                inputFrame.setLayout(inputFrameLayout);
                inputFrameLayout.setVgap(5);
                JLabel menuNameLabel = new JLabel("Name for Menu");
                JTextField nameTextField = new JTextField();
                JButton saveNameBtn = new JButton("Save");
                inputFrame.add(menuNameLabel);
                inputFrame.add(nameTextField);
                inputFrame.add(saveNameBtn);
                inputFrame.pack();
                inputFrame.setVisible(true);
                inputFrame.setTitle("Menu Manager-Input name");
                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                inputFrame.setBounds(((screen.width - inputFrame.getWidth()) / 2), ((screen.height - inputFrame.getHeight()) / 2), inputFrame.getWidth(), inputFrame.getHeight());
                
                saveNameBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        inputFrame.setVisible(false);
                        
                        if(!nameTextField.getText().equals("")){
                            String nameOfMenu = nameTextField.getText();
                            CRTDMenuListModel.addElement(nameOfMenu);
                            Entree entree = null;
                            for (int i = 0; i < menuManager.getEntrees().size(); i++) {
                                if(menuManager.getEntrees().get(i).getName().equals(entreeComboBox.getSelectedItem())){
                                    entree = menuManager.getEntrees().get(i);
                                }
                            }
                            Side side = null;
                            for (int i = 0; i < menuManager.getSides().size(); i++) {
                                if(menuManager.getSides().get(i).getName().equals(sideComboBox.getSelectedItem())){
                                    side = menuManager.getSides().get(i);
                                }
                            }
                            Salad salad = null;
                            for (int i = 0; i < menuManager.getSalads().size(); i++) {
                                if(menuManager.getSalads().get(i).getName().equals(saladComboBox.getSelectedItem())){
                                    salad = menuManager.getSalads().get(i);
                                }
                            }
                            Dessert dessert = null;
                            for (int i = 0; i < menuManager.getDesserts().size(); i++) {
                                if(menuManager.getDesserts().get(i).getName().equals(dessertComboBox.getSelectedItem())){
                                    dessert = menuManager.getDesserts().get(i);
                                }
                            }
                           Menu menu = new Menu(nameOfMenu,entree,side,salad,dessert);
                           
                            menus.add(menu);
                        }else{
                            JOptionPane.showMessageDialog(inputFrame,"Name is empty,PLS try again","Error",ERROR_MESSAGE);
                        }
                    }
                });

            }
        });

        genRandomBtn.addActionListener(e -> {
            
            JFrame inputFrame = new JFrame();
            GridLayout inputFrameLayout = new GridLayout(3,1);
            inputFrame.setLayout(inputFrameLayout);
            inputFrameLayout.setVgap(5);
            JLabel menuNameLabel = new JLabel("Name for Menu");
            JTextField nameTextField = new JTextField();
            JButton saveNameBtn = new JButton("Save");
            inputFrame.add(menuNameLabel);
            inputFrame.add(nameTextField);
            inputFrame.add(saveNameBtn);
            inputFrame.pack();
            inputFrame.setVisible(true);
            inputFrame.setTitle("Menu Manager-Input name");
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            inputFrame.setBounds(((screen.width - inputFrame.getWidth()) / 2), ((screen.height - inputFrame.getHeight()) / 2), inputFrame.getWidth(), inputFrame.getHeight());
            
            saveNameBtn.addActionListener(e1 -> {
                if(!nameTextField.getText().equals("")) {
                    String nameOfMenu =nameTextField.getText();
                    Menu menu = menuManager.randomMenu(nameOfMenu);
                    //add to the list on Right side
                    CRTDMenuListModel.addElement(nameOfMenu);
                    //add to the collection
                    menus.add(menu);
                }else {
                    JOptionPane.showMessageDialog(inputFrame,"Name is empty,PLS try again","Error",ERROR_MESSAGE);
                }
            });
        });

        genMinCalBtn.addActionListener(e1 -> {
            
            JFrame inputFrame = new JFrame();
            GridLayout inputFrameLayout = new GridLayout(3,1);
            inputFrame.setLayout(inputFrameLayout);
            inputFrameLayout.setVgap(5);
            JLabel menuNameLabel = new JLabel("Name for Menu");
            JTextField nameTextField = new JTextField();
            JButton saveNameBtn = new JButton("Save");
            inputFrame.add(menuNameLabel);
            inputFrame.add(nameTextField);
            inputFrame.add(saveNameBtn);
            inputFrame.pack();
            inputFrame.setVisible(true);
            inputFrame.setTitle("Menu Manager-Input name");
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            inputFrame.setBounds(((screen.width - inputFrame.getWidth()) / 2), ((screen.height - inputFrame.getHeight()) / 2), inputFrame.getWidth(), inputFrame.getHeight());
           
            saveNameBtn.addActionListener(e2 -> {
                if(!nameTextField.getText().equals("")) {
                    String nameOfMenu =nameTextField.getText();
                    Menu menu = menuManager.minCaloriesMenu(nameOfMenu);
                    //add to the list on Right side
                    CRTDMenuListModel.addElement(nameOfMenu);
                    //add to the collection
                    menus.add(menu);
                }else {
                    JOptionPane.showMessageDialog(inputFrame,"Name is empty,PLS try again","Error",ERROR_MESSAGE);
                }
            });
        });

        genMaxCalBtn.addActionListener(e3 -> {
            
            JFrame inputFrame = new JFrame();
            GridLayout inputFrameLayout = new GridLayout(3,1);
            inputFrame.setLayout(inputFrameLayout);
            inputFrameLayout.setVgap(5);
            JLabel menuNameLabel = new JLabel("Name for Menu");
            JTextField nameTextField = new JTextField();
            JButton saveNameBtn = new JButton("Save");
            inputFrame.add(menuNameLabel);
            inputFrame.add(nameTextField);
            inputFrame.add(saveNameBtn);
            inputFrame.pack();
            inputFrame.setVisible(true);
            inputFrame.setTitle("Menu Manager-Input name");
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            inputFrame.setBounds(((screen.width - inputFrame.getWidth()) / 2), ((screen.height - inputFrame.getHeight()) / 2), inputFrame.getWidth(), inputFrame.getHeight());
            
            saveNameBtn.addActionListener(e1 -> {
                if(!nameTextField.getText().equals("")) {
                    String nameOfMenu =nameTextField.getText();
                    Menu menu = menuManager.maxCaloriesMenu(nameOfMenu);
                    //add to the list on Right side
                    CRTDMenuListModel.addElement(nameOfMenu);
                    //add to the collection
                    menus.add(menu);
                }else {
                    JOptionPane.showMessageDialog(inputFrame,"Name is empty,PLS try again","Error",ERROR_MESSAGE);
                }
            });
        });

        detailsBtn.addActionListener(e ->{
            if(CRTDMenuList.isSelectionEmpty()){
                JOptionPane.showMessageDialog(mainFrame,"No Menu item is selected","Error",ERROR_MESSAGE);
            }else if(CRTDMenuListModel.isEmpty()){
                JOptionPane.showMessageDialog(mainFrame,"No Created Menu, Create your Menu first","Error",ERROR_MESSAGE);

            }else{
                Menu menu = null;
                for (int i = 0; i < this.menus.size(); i++) {
                    if(this.menus.get(i).getName().equals(CRTDMenuList.getSelectedValue())){
                        menu = menus.get(i);
                    }
                }
                initSecondaryWindow(menu);
            }

        });

        deleteAllBtn.addActionListener(e -> {
           CRTDMenuListModel.removeAllElements();
            JOptionPane.showMessageDialog(mainFrame,"Deleted All elements","Finished",INFORMATION_MESSAGE);
        });

        saveBtn.addActionListener(e -> {
            FileManager.writeItems("data/menus.txt", this.menus);
            JOptionPane.showMessageDialog(mainFrame,"Write Menu to the file completed","Finished",INFORMATION_MESSAGE);

        });


    }

    private void initSecondaryWindow(Menu menu) {
        JFrame secFrame = new JFrame("Menu: My own Menu");
        //JLabels
        JLabel totalCalLBL = new JLabel("Total calories:");
        JLabel totalPriceLBL = new JLabel("Total price: $");
        //JTextArea
        JTextArea entreeTA = new JTextArea();
        JTextArea sideTA = new JTextArea();
        JTextArea saladTA = new JTextArea();
        JTextArea dessertTA = new JTextArea();
        //JTextField
        JTextField totalPriceFLD = new JTextField();
        JTextField totalCalFLD = new JTextField();

        JLabel entreeLabel = new JLabel("Entree");
        JLabel sideLabel = new JLabel("Side");
        JLabel saladLabel = new JLabel("Salad");
        JLabel dessertLabel = new JLabel("Dessert");

        entreeTA.setColumns(50);
        sideTA.setColumns(50);
        saladTA.setColumns(50);
        dessertTA.setColumns(50);

        entreeTA.setRows(5);
        sideTA.setRows(5);
        saladTA.setRows(5);
        dessertTA.setRows(5);

        entreeTA.setLineWrap(true);
        sideTA.setLineWrap(true);
        saladTA.setLineWrap(true);
        dessertTA.setLineWrap(true);
        
        entreeTA.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        sideTA.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        saladTA.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        dessertTA.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        totalPriceFLD.setColumns(10);
        totalCalFLD.setColumns(10);
        totalPriceFLD.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        totalCalFLD.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        //set Contents.
        entreeTA.setText(menu.getEntree().getName()+"\n"+menu.getEntree().getDescription()+"Calories: "+menu.getEntree().getCalories()+"Price: $"+menu.getEntree().getPrice());
        sideTA.setText(menu.getSide().getName()+"\n"+menu.getSide().getDescription()+"Calories: "+menu.getSide().getCalories()+"Price: $"+menu.getSide().getPrice());
        saladTA.setText(menu.getSalad().getName()+"\n"+menu.getSalad().getDescription()+"Calories: "+menu.getSalad().getCalories()+"Price: $"+menu.getSalad().getPrice());
        dessertTA.setText(menu.getDessert().getName()+"\n"+menu.getDessert().getDescription()+"Calories: "+menu.getDessert().getCalories()+"Price: $"+menu.getDessert().getPrice());

        totalCalFLD.setText(Integer.toString(menu.totalCalories()));
        totalPriceFLD.setText(Integer.toString(menu.totalPrice()));

        //Layout manage
        secFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,2,5,10);
        setGBC(0,0,1,gbc);
        secFrame.add(entreeLabel,gbc);
        setGBC(1,0,4,gbc);
        secFrame.add(entreeTA,gbc);
        setGBC(0,1,1,gbc);
        secFrame.add(sideLabel,gbc);
        setGBC(1,1,4,gbc);
        secFrame.add(sideTA,gbc);
        setGBC(0,2,1,gbc);
        secFrame.add(saladLabel,gbc);
        setGBC(1,2,4,gbc);
        secFrame.add(saladTA,gbc);
        setGBC(0,3,1,gbc);
        secFrame.add(dessertLabel,gbc);
        setGBC(1,3,4,gbc);
        secFrame.add(dessertTA,gbc);
        setGBC(0,4,1,gbc);
        secFrame.add(totalCalLBL,gbc);
        setGBC(0,5,1,gbc);
        secFrame.add(totalPriceLBL,gbc);
        gbc.anchor = GridBagConstraints.WEST ;
        setGBC(1,5,4,gbc);
        secFrame.add(totalPriceFLD,gbc);
        setGBC(1,4,4,gbc);
        secFrame.add(totalCalFLD,gbc);
        secFrame.setVisible(true);
        secFrame.pack();
        secFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        secFrame.setBounds(((screen.width - secFrame.getWidth()) / 2), ((screen.height - secFrame.getHeight()) / 2), secFrame.getWidth(), secFrame.getHeight());
    }

    private void setGBC(int x, int y,int width,GridBagConstraints gbc){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
    }
    public static void main(String[] args) {
        MenuManagerGUI gui = new MenuManagerGUI();
        gui.mainFrame.setVisible(true);
    }
}
