package model;

import java.io.Serializable;

/**
 * Expert Level´s (ENUM)
 *
 * @author LAPR2-2020-G038
 */
public enum LevelExpert implements Serializable {
    /**
     * Junior
     */
    JUNIOR {
        @Override
        public String toString() {
            return "Junior";
        }
    },
    /**
     * Senior
     */
    SENIOR {
        @Override
        public String toString() {
            return "Senior";
        }
    };
}
