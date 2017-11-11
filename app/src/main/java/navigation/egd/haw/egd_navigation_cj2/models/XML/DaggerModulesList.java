package navigation.egd.haw.egd_navigation_cj2.models.XML;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 *
 * Created by prann on 11/11/2017.
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
