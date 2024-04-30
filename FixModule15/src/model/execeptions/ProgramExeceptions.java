package model.execeptions;

import java.io.Serial;

public class ProgramExeceptions extends Exception{
    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;
    public ProgramExeceptions(String msg){
        super(msg);
    }

}
