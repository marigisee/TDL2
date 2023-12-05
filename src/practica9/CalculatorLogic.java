package practica9;

public class CalculatorLogic {

    private String operand;

    private String operator;
    private double result;

    public CalculatorLogic() {
        this.operand = "0";
        this.operator = " ";
        this.result = 0;
    }


    public void setResult(double result) {
        this.result = result;
    }

    public String getOperand() {
        return this.operand;
    }

    public String getOperator() {
        return this.operator;
    }

    public double getResult() {
        return this.result;
    }

    /**
     * La asignación ocurre en la variable operand.
     * @param operand
     */
    public void assignOperand(String operand) {

        // Ingreso 0 y el valor que ya esta almacenado en operand no es 0
        if ( (operand.equals("0")) && (!(this.operand=="0")) ){
            this.operand = this.operand + operand;
        }
        // No ingreso 0
        else {
            //Si ingresamos un numero anteriormente, concateno
            if (this.operand.equals("0")) {
                this.operand = operand;
            } else {
                //Asigno el valor ingresado
                this.operand += operand;
            }
        }

    }


    public void setOperator(String operator) {

        /*
        - result se actualiza en la operacion compute()
        -- dicho método se invoca cuando se presiona el botón igual
        dasda

        */

        //Si no hay un valor almacenado en operando y no hay un resultado previo
        if ((this.operand.equals("")) && (this.result == 0)) {
            return; //No hacemos nada
        }
        else {
            // Si el operador es distinto de =
            if (!(operator.equals("="))) {
                this.operator = operator;
                if (this.result == 0) {
                    this.result = Double.parseDouble(this.operand);
                }
                this.operand = "0";
            } else {
                //Si el operador es =
                compute();
                this.operand = "0";
            }
        }
    }

    /**
     * Realiza la operación correspondiente
     */
    public void compute() {
        if (this.operand.equals(" ")) {
            return;
        }
        switch (this.operator) {
            case "+":
                this.result += Double.parseDouble(this.operand);
                break;
            case "-":
                this.result -= Double.parseDouble(this.operand);
                break;
            case "*":
                this.result *= Double.parseDouble(this.operand);
                break;
            case "/":
                this.result /= Double.parseDouble(this.operand);
                break;
            default:
                return;
        }

    }

    public boolean isEven() {
        return Double.parseDouble(this.operand) % 2 == 0;
    }

    public boolean isIndetermination() {
        return this.result != 0 && this.operand.equals("0");
    }

    public void resetLogic(){
        this.operand = "0";
        this.operator = " ";
        this.result = 0;
    }

}
