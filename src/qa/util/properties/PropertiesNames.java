package qa.util.properties;

public enum PropertiesNames {
    BROWSER("browser"),
    DRIVERS_DIR("drivers.dir"),
    CONFIG_DIR("config.dir"),
    UPLOAD_DIR("upload.dir"),
    BASE_URL("base.url"),
    ADMIN_URL("admin.url"),
    BUILD_VERSION("build.version"),
    REFERENCE("Reporting  © Powered by ");

    private String value;

    private PropertiesNames(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
