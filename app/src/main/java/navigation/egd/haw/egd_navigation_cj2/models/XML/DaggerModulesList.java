package navigation.egd.haw.egd_navigation_cj2.models.XML;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * @author prannoy
 * This is a model for the config xml file which can be used to instantiate the classes for the DI with dagger framework.
 *
 * The Xml is parsed with nested lists(SimpleXML). Example Below:
 * http://simple.sourceforge.net/download/stream/doc/tutorial/tutorial.php#list
 */

@Root
public class DaggerModulesList {
    @ElementList
    private List<DaggerModule> moduleList;

    public List<DaggerModule> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<DaggerModule> moduleList) {
        this.moduleList = moduleList;
    }
}
