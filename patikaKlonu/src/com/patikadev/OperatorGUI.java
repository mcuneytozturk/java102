package com.patikadev;

import com.patikadev.helper.Config;
import com.patikadev.helper.Helper;
import com.patikadev.model.Operator;
import com.patikadev.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JButton çıkışYapButton;
    private JPanel pnl_top;
    private JScrollPane scrl_user_list;
    private JPanel pnl_user_list;
    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;
    private JTextField fld_user_name;
    private JTextField fld_user_uname;
    private JTextField fld_user_pass;
    private JLabel area_password;
    private JLabel area_username;
    private JLabel area_name;
    private JButton btn_user_add;
    private JComboBox cbm_user_type;
    private JButton loginButton;
    private final Operator operator;

    public OperatorGUI(Operator operator) {
        this.operator = operator;
        Helper.setLayout();
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        // ModelUserList
        mdl_user_list = new DefaultTableModel();
        Object[] col_user_list = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
        row_user_list = new Object[col_user_list.length];

        mdl_user_list.setColumnIdentifiers(col_user_list);

        loadUserModel();

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);

        btn_user_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Helper.isFldEmpty(fld_user_name) || Helper.isFldEmpty(fld_user_uname) || Helper.isFldEmpty(fld_user_pass)) {
                    Helper.showMsg("fill");
                } else {
                    String name = fld_user_name.getText();
                    String uname = fld_user_uname.getText();
                    String pass = fld_user_pass.getText();
                    String type = cbm_user_type.getSelectedItem().toString();
                    if (User.add(name, uname, pass, type)) {
                        Helper.showMsg("done");
                        loadUserModel();
                    }else{
                        Helper.showMsg("error");
                    }
                }
            }
        });
    }

    public void loadUserModel(){
        DefaultTableModel clearModel=(DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);

        for (User user : User.getUserList()) {
            int i = 0;
            row_user_list[i++] = user.getId();
            row_user_list[i++] = user.getName();
            row_user_list[i++] = user.getUname();
            row_user_list[i++] = user.getPassword();
            row_user_list[i++] = user.getType();
            mdl_user_list.addRow(row_user_list);
        }
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
