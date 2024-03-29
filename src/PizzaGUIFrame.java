import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PizzaGUIFrame extends JFrame {

    JPanel mainPnl;
    JPanel radioPnl;
    JRadioButton thin;
    JRadioButton reg;
    JRadioButton dd;

    JPanel comboPnl;
    JComboBox comboBox;
    JCheckBox peppCB;
    JCheckBox baconCB;
    JCheckBox sausageCB;
    JCheckBox pineappleCB;
    JCheckBox shroomsCB;
    JCheckBox mustCB;
    JCheckBox bananaCB;
    JCheckBox PeppersCB;
    JCheckBox onionCB;

    JPanel cbPnl;

    JPanel receiptPnl;
    String res;
    JTextArea receipt;
    JScrollPane scroller;

    JPanel controlPanel;
    JButton orderBtn;
    JButton clearBtn;
    JButton quitBtn;

    public PizzaGUIFrame() {

        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(5, 0));

        createComboPnl();
        mainPnl.add(comboPnl);

        createRadioPnl();
        mainPnl.add(radioPnl);

        createCbPnl();
        mainPnl.add(cbPnl);

        createReceiptPnl();
        mainPnl.add(receiptPnl);

        createControlPnl();
        mainPnl.add(controlPanel);

        add(mainPnl);
        setSize(560, 1100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Pizza Order Form");
    }

    private void createRadioPnl() {

        radioPnl = new JPanel();
        radioPnl.setLayout(new GridLayout(1, 3));
        radioPnl.setBorder(new TitledBorder(new EtchedBorder(), "Crust (Choose one)*"));

        reg = new JRadioButton("Regular");
        thin = new JRadioButton("Thin");
        dd = new JRadioButton("Deep-Dish");

        radioPnl.add(reg);
        radioPnl.add(thin);
        radioPnl.add(dd);

        reg.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(thin);
        group.add(reg);
        group.add(dd);

    }
    private void createComboPnl() {
        comboPnl = new JPanel();
        comboPnl.setLayout(new GridLayout(1, 0));
        comboPnl.setBorder(new TitledBorder(new EtchedBorder(), "Size (Select one)*"));

        String[] size = {"Small: $8.00", "Medium: $12.00", "Large: $16.00", "Super: $20.00"};
        comboBox = new JComboBox(size);
        comboPnl.add(comboBox);
    }
    private void createCbPnl() {

        cbPnl = new JPanel();
        cbPnl.setLayout(new GridLayout(3, 3));
        cbPnl.setBorder(new TitledBorder(new EtchedBorder(), "Toppings ($1 Per Extra Topping)"));

        peppCB = new JCheckBox("Pepperoni");
        baconCB = new JCheckBox("Bacon");
        sausageCB = new JCheckBox("Sausage");

        shroomsCB = new JCheckBox("Mushrooms (The illegal kind)");
        mustCB = new JCheckBox("Mustard (for psychos)");
        bananaCB = new JCheckBox("A Whole Banana");

        pineappleCB = new JCheckBox("Pineapple :(");
        PeppersCB = new JCheckBox("Peppers");
        onionCB = new JCheckBox("Onion");

        cbPnl.add(peppCB);
        cbPnl.add(baconCB);
        cbPnl.add(sausageCB);
        cbPnl.add(shroomsCB);
        cbPnl.add(mustCB);
        cbPnl.add(bananaCB);
        cbPnl.add(pineappleCB);
        cbPnl.add(PeppersCB);
        cbPnl.add(onionCB);

    }
    private void createReceiptPnl() {
        receiptPnl = new JPanel();
        receiptPnl.setLayout(new GridLayout(0, 1));
        receiptPnl.setBorder(new TitledBorder(new EtchedBorder(), "Order Details"));

        receipt = new JTextArea();
        scroller = new JScrollPane(receipt);
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        receipt.setEditable(false);
        receiptPnl.add(scroller);
    }
    private void createControlPnl() {
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 3));
        orderBtn = new JButton("Place Order");
        orderBtn.addActionListener((ActionEvent ae) -> {
            String res = "";
            String subt = "";
            double subtotal = 0;
            res += ("=======================================================\n");

            if (reg.isSelected()) {
                res += ("   Regular | ");
                if (comboBox.getSelectedIndex() == 0) {
                    res += ("Small                                                            $8.00\n");
                    subtotal += 8;
                }
                if (comboBox.getSelectedIndex() == 1) {
                    res += ("Medium                                                        $12.00\n");
                    subtotal += 12;
                }
                if (comboBox.getSelectedIndex() == 2) {
                    res += ("Large                                                            $16.00\n");
                    subtotal += 16;
                }
                if (comboBox.getSelectedIndex() == 3) {
                    res += ("Super                                                            $20.00\n");
                    subtotal += 20;
                }
            }
            if (thin.isSelected()) {
                res += ("   Thin | ");
                if (comboBox.getSelectedIndex() == 0) {
                    res += ("Small                                                                 $8.00\n");
                    subtotal += 8;
                }
                if (comboBox.getSelectedIndex() == 1) {
                    res += ("Medium                                                             $12.00\n");
                    subtotal += 12;
                }
                if (comboBox.getSelectedIndex() == 2) {
                    res += ("Large                                                                 $16.00\n");
                    subtotal += 16;
                }
                if (comboBox.getSelectedIndex() == 3) {
                    res += ("Super                                                                 $20.00\n");
                    subtotal += 20;
                }
            }
            if (dd.isSelected()) {
                res += ("   Deep Dish | ");
                if (comboBox.getSelectedIndex() == 0) {
                    res += ("Small                                                        $8.00\n");
                    subtotal += 8;
                }
                if (comboBox.getSelectedIndex() == 1) {
                    res += ("Medium                                                    $12.00\n");
                    subtotal += 12;
                }
                if (comboBox.getSelectedIndex() == 2) {
                    res += ("Large                                                        $16.00\n");
                    subtotal += 16;
                }
                if (comboBox.getSelectedIndex() == 3) {
                    res += ("Super                                                        $20.00\n");
                    subtotal += 20;
                }
            }
            if (peppCB.isSelected()) {
                res += ("     - Pepperoni                                                               $1.00\n");
                subtotal += 1;
            }
            if (baconCB.isSelected()) {
                res += ("     - Bacon                                                                     $1.00\n");
                subtotal += 1;
            }
            if (sausageCB.isSelected()) {
                res += ("     - Sausage                                                                  $1.00\n");
                subtotal += 1;
            }
            if (shroomsCB.isSelected()) {
                res += ("     - Shrooms                                                            $1.00\n");
                subtotal += 1;
            }
            if (mustCB.isSelected()) {
                res += ("     - Mustard                                                                     $1.00\n");
                subtotal += 1;
            }
            if (bananaCB.isSelected()) {
                res += ("     - Banana                                                              $1.00\n");
                subtotal += 1;
            }
            if (pineappleCB.isSelected()) {
                res += ("     - Pineapple  >:(                                                          $1.00\n");
                subtotal += 1;
            }
            if (PeppersCB.isSelected()) {
                res += ("     - Peppers                                                        $1.00\n");
                subtotal += 1;
            }
            if (onionCB.isSelected()) {
                res += ("     - Onions                                                                  $1.00\n");
                subtotal += 1;
            }
            res += "\n   Sub-total:                                                                  $";
            res += String.format("%.2f", subtotal);
            res += "\n";
            res += "   Tax:                                                                           $";
            double tax = subtotal * 0.07;
            res += String.format("%.2f", tax);
            res += "\n";
            res += "------------------------------------------------------------------\n";
            res += "   Total:                                                                        $";
            double total = (subtotal * 0.07) + subtotal;
            res += String.format("%.2f", total);
            res += ("\n=====================================================");
            receipt.append(res);
        });
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener((ActionEvent ae) -> {
            peppCB.setSelected(false);
            sausageCB.setSelected(false);
            baconCB.setSelected(false);
            mustCB .setSelected(false);
            bananaCB.setSelected(false);
            shroomsCB.setSelected(false);
            PeppersCB.setSelected(false);
            onionCB.setSelected(false);
            pineappleCB.setSelected(false);
            receipt.setText(null);
            comboBox.setSelectedIndex(0);
            reg.setSelected(true);
        });
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPanel.add(orderBtn);
        controlPanel.add(clearBtn);
        controlPanel.add(quitBtn);
    }
}