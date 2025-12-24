package pages;

public class TaskPage extends BasePage {
    public TaskPage() {
        super();
    }

    private String taskCreateModal = "//h2[text()=\"Crear nueva Tarea\"]";
    private String buttonTaskNew = "//button[text()=\"Nueva Tarea\"]";
    private String titleTask = "//input[@id=\"title\"]";
    private String descriptionTask = "//textarea[@id=\"title\"]";
    private String buttonTaskCreate = "//button[text()=\"Crear Tarea\"]";
    private String taskCreateSuccess = "//div[@role=\"alert\"]";
    private String dateTask = "//label[text()=\"Fecha Vencimiento\"]//following-sibling::div/input";
    private String priorityTask = "//label[text()=\"Prioridad\"]//following-sibling::div/input";
    private String clickTask = "//a[contains(@href,\"task\")]";
    private String clickTaskCompleted = "//button[text()=\"Marcar Tarea Completada\"]";
    private String statusTask = "//td[text()=\"Tarea Completada\"]";
    private String getTable = "//a[@role=\"checkbox\"]";
    private String alertNotTask = "//div[@role=\"alert\"]";

    public boolean TaskList() {
        return elementIsDisplayed(getTable);

    }

    public void clickTaskNew() {
        clickElement(buttonTaskNew);
    }

    public boolean taskCreateWindow() {
        return elementIsDisplayed(taskCreateModal);
    }

    public void fillNewTask(String titulo, String descripcion, String fechaDeVencimiento, String prioridad) {
        write(titleTask, titulo);
        write(descriptionTask, descripcion);
        write(dateTask, fechaDeVencimiento);
        write(priorityTask, prioridad);

    }

    public void clickTaskCreate() {
        clickElement(buttonTaskCreate);
    }

    public boolean taskCreateSuccess() {
        System.out.println(elementIsDisplayed(taskCreateSuccess));
        return elementIsDisplayed(taskCreateSuccess);
    }

    public void clickTask() {
        clickElement(clickTask);
    }

    public void clickTaskCompleted() {
        clickElement(clickTaskCompleted);
    }

    public boolean changeTaskStatus() {
        return elementIsDisplayed(statusTask);
    }

    public boolean isClickleableButton() {
        return isElementClickable(clickTaskCompleted);
    }

    public boolean alertNotTask() {
        return elementIsDisplayed(alertNotTask);
    }
}