package controladora;

import telas.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlaMenu implements ActionListener {
    final Menu menu;

    public ControlaMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent EventoBotao) {
        if (EventoBotao.getSource().equals(menu.novaVenda)) {

        } else if (EventoBotao.getSource().equals(menu.novaDevolucao)) {

        }
    }
}
