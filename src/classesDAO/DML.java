/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package classesDAO;

/**
 *
 * @author Alejandro
 */
public interface DML <T>{
    boolean insert(T objeto);
    boolean delete(int id);
    boolean update(T objeto);
    boolean activate(int id);
}
