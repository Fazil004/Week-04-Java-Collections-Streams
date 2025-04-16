
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface MealPlan {
    String getDescription();
    List<String> getIngredients();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getDescription() {
        return "Delicious Vegetarian Meal";
    }

    @Override
    public List<String> getIngredients() {
        return List.of("Tofu", "Broccoli", "Carrots", "Rice");
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getDescription() {
        return "Nutritious Vegan Meal";
    }

    @Override
    public List<String> getIngredients() {
        return List.of("Lentils", "Spinach", "Quinoa", "Tomatoes");
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getDescription() {
        return "Energy-Boosting Keto Meal";
    }

    @Override
    public List<String> getIngredients() {
        return List.of("Avocado", "Eggs", "Bacon", "Cheese");
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getDescription() {
        return "Muscle-Building High-Protein Meal";
    }

    @Override
    public List<String> getIngredients() {
        return List.of("Chicken Breast", "Beans", "Greek Yogurt", "Spinach");
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public void displayMeal() {
        System.out.println("--- Meal Plan ---");
        System.out.println("Type: " + mealPlan.getDescription());
        System.out.println("Ingredients: " + mealPlan.getIngredients());
        System.out.println("------------------");
    }
}

class MealPlanGenerator {
    private static Random random = new Random();

    public static <T extends MealPlan> Meal<T> generatePlan(Class<T> mealType) {
        try {
            if (MealPlan.class.isAssignableFrom(mealType)) {
                T newMealPlan = mealType.getDeclaredConstructor().newInstance();
                System.out.println("Generated a " + newMealPlan.getDescription());
                return new Meal<>(newMealPlan);
            } else {
                System.out.println("Invalid meal type requested.");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error generating meal plan: " + e.getMessage());
            return null;
        }
    }

    public static <T extends MealPlan> void processMeal(Meal<T> meal) {
        if (meal != null) {
            System.out.println("Processing meal: " + meal.getMealPlan().getDescription());
        } else {
            System.out.println("No meal to process.");
        }
    }
}

public class MealPlanSystem {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianMeal = MealPlanGenerator.generatePlan(VegetarianMeal.class);
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generatePlan(VeganMeal.class);
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generatePlan(KetoMeal.class);
        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generatePlan(HighProteinMeal.class);

        if (vegetarianMeal != null) vegetarianMeal.displayMeal();
        if (veganMeal != null) veganMeal.displayMeal();
        if (ketoMeal != null) ketoMeal.displayMeal();
        if (highProteinMeal != null) highProteinMeal.displayMeal();

        MealPlanGenerator.processMeal(ketoMeal);
    }
}

