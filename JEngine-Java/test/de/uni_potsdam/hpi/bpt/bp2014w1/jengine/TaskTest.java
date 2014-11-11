/**
 * Created by jaspar.mang on 10.11.14.
 */
package de.uni_potsdam.hpi.bpt.bp2014w1.jengine;

import org.junit.Test;

import static org.junit.Assert.*;



public class TaskTest {
    @Test
    public void testInit() {
        Data data = new Data();
        Task task= new Task(data);
        task.init(1);
        assertTrue(task.completedTask.isEmpty());
        assertTrue(task.enabledTask.remove(new Integer(2)));
        assertTrue(task.enabledTask.remove(new Integer(8)));
        assertTrue(task.enabledTask.isEmpty());
        assertEquals(5, 5);
        task.init(1);
        task.init(1);
        assertTrue(task.completedTask.isEmpty());
        assertTrue(task.enabledTask.remove(new Integer(2)));
        assertTrue(task.enabledTask.remove(new Integer(8)));
        assertTrue(task.enabledTask.isEmpty());
        assertEquals(5, 5);
    }

    @Test
    public void testCompleteActivity(){
        Data data = new Data();
        data.init(1);
        Task task= new Task(data);
        task.init(1);
        task.completeActivity(2);
        assertTrue(task.completedTask.contains(2));
        assertFalse(task.enabledTask.contains(2));
    }
}
