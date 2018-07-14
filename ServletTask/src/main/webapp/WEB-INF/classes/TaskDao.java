package com.test.web.dao;

import com.test.web.model.Task;

public class TaskDao {

	public Task getTask(int id)
	{
		Task task = new Task();
		task.setId(101);
		task.setName("Tod");
		task.setDescription("Feeling Happy");
		return task;
	}
}
