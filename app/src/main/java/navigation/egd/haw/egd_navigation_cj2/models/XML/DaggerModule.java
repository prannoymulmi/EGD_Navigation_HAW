package navigation.egd.haw.egd_navigation_cj2.models.XML;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * @author prannoy
 * Created by prann on 11/11/2017.
 */

@Root(name = "module")
public class DaggerModule {
    @Attribute(name="name")
    private String moduleName;

    @ElementList(type = DaggerModuleProviders.class)
    private List<DaggerModuleProviders> methodList;

    public List<DaggerModuleProviders> getmethodList() {
        return methodList;
    }

    public void setmethodList(List<DaggerModuleProviders> methodList) {
        this.methodList = methodList;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }


}
