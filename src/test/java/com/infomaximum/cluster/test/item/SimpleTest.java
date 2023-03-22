package com.infomaximum.cluster.test.item;

import com.infomaximum.cluster.component.memory.MemoryComponent;
import com.infomaximum.cluster.test.Clusters;
import com.infomaximum.cluster.test.component.custom1.Custom1Component;
import com.infomaximum.cluster.test.component.custom1.remote.RControllerCustom1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kris on 26.08.16.
 */
public class SimpleTest  {

    private final static Logger log = LoggerFactory.getLogger(SimpleTest.class);

    @Test
    public void test1() throws Exception {
        try (Clusters clusters = new Clusters.Builder().build()) {
            MemoryComponent memoryComponent = clusters.getCluster1().getAnyLocalComponent(MemoryComponent.class);
            RControllerCustom1 rControllerCustom1 = memoryComponent.getRemotes().get(Custom1Component.class, RControllerCustom1.class);

            String result = rControllerCustom1.empty();

            Assertions.assertEquals(null, result);
        }

    }

}
