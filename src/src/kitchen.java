import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class kitchen {
    public static void main(String[] args) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Arroz bomba", 1500));
        ingredients.add(new Ingredient("Pollo de corral", null));
        ingredients.add(new Ingredient("Conejo", 500));
        ingredients.add(new Ingredient("Judía verde plana", 500));
        ingredients.add(new Ingredient("Garrofó", 500));
        ingredients.add(new Ingredient("Alcachofa", 500));
        ingredients.add(new Ingredient("Aceite de oliva virgen extra", null));
        ingredients.add(new Ingredient("Pimentón dulce", null));
        ingredients.add(new Ingredient("Tomate triturado", null));
        ingredients.add(new Ingredient("Azafrán", null));
        ingredients.add(new Ingredient("Romero fresco", null));
        ingredients.add(new Ingredient("Sal", null));

        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new Instruction("Dificultad: Media", null));
        instructions.add(new Instruction("Tiempo total", 85));
        instructions.add(new Instruction("Elaboración", 10));
        instructions.add(new Instruction("Cocción", 75));
        instructions.add(new Instruction("Reposo", 5));

        try {
            new GenerateFood().generateTxt(ingredients, instructions);
        } catch (Exception er) {
            System.err.println(er.getMessage());
        }
    }
}

class Ingredient {
    private String name;
    private Integer grams;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrams() {
        return grams;
    }

    public void setGrams(Integer grams) {
        this.grams = grams;
    }

    public Ingredient(String name, Integer grams) {
        this.name = name;
        this.grams = grams;
    }

    @Override
    public String toString() {
        if (grams != null) return name + ": " + grams + "g";
        else return name;
    }
}

class Instruction {
    private String instruction;
    private Integer minutes;

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Instruction(String instruction, Integer minutes) {
        this.instruction = instruction;
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        if (minutes != null) return instruction + " -> " + minutes + "min";
        else return instruction;
    }
}

class GenerateFood implements GenerateTxt {
    @Override
    public void generateTxt(List<Ingredient> list1, List<Instruction> list2) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File("txt1.txt"));
        list1.forEach(printWriter::println);
        printWriter.close();

        printWriter = new PrintWriter(new File("txt2.txt"));
        list2.forEach(printWriter::println);
        printWriter.close();
    }
}

interface GenerateTxt {
    void generateTxt(List<Ingredient> list1, List<Instruction> list2) throws FileNotFoundException;
}
