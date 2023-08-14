package com.patikadev;

import com.patikadev.helper.Config;
import com.patikadev.helper.Helper;
import com.patikadev.model.Operator;
import com.patikadev.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OperatorGUI extends JFrame{
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JButton çıkışYapButton;
    private JPanel pnl_top;
    private JScrollPane scrl_user_list;
    private JPanel pnl_user_list;
    private JTable tbl_user_list;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loginButton;
    private final Operator operator;
    public OperatorGUI(Operator operator) {
        this.operator = operator;
        Helper.setLayout();
        add(wrapper);
        setSize(1000,500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        // ModelUserList
        mdl_user_list = new DefaultTableModel();
        Object[] col_user_list = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
        /*
        Object[] firstRow = {1, "Cüneyt ÖZTÜRK", "mcuneytozturk", "123", "operator"};
        mdl_user_list.addRow(firstRow);
        */

        mdl_user_list.setColumnIdentifiers(col_user_list);

        for(User user: User.getUserList()){
            Object[] row = new Object[col_user_list.length];
            row[0] = user.getId();
            row[1] = user.getName();
            row[2] = user.getUname();
            row[3] = user.getPassword();
            row[4] = user.getType();
            mdl_user_list.addRow(row);
        }

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);
    }

    public static void main(String[] args) {
        Operator op = new Operator();
        op.setId(1);
        op.setName("Cüneyt");
        op.setPassword("vallaha billaha");
        op.setType("Operatör");
        op.setUname("mco73");
        OperatorGUI ex = new OperatorGUI(op);
    }
}
