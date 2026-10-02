package Controlador;

import modelo.TipoApuesta;

import javax.swing.*;

public class RuletaController {
    JComboBox<TipoApuesta> cboTipo = new JComboBox<>(TipoApuesta.values());
    TipoApuesta tipo = (TipoApuesta) cboTipo.getSelectedItem();
}
