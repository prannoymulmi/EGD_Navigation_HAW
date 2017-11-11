package navigation.egd.haw.egd_navigation_cj2.models.XML;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;


/**
 *
 * Created by prann on 11/11/2017.
 */
 @Root(name="methodProvider")
public class DaggerModuleProviders {
    @Attribute
    private String className;

    @Attribute
    private String packageName;

    public String getClassName() {
        return className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
