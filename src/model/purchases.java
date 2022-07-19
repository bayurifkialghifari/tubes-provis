/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import core.ORM;
/**
 *
 * @author mac
 */
public class purchases extends ORM {
    
    public void change_table()
    {
        this.set_table("purchase");
    }
}
