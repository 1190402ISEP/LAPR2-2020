/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author LAPR2-2020-G038
 */
public enum FileType implements Serializable{
    FILE_CSV {
        @Override
        public String toString() {
            return String.format("*.csv");
        }
    },
    FILE_TXT {
        @Override
        public String toString() {
            return String.format("*.txt");
        }
    };
}
