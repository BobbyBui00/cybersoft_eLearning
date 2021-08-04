package cybersoft.group6.finalProject.eLearning.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class MapDtoToModel<E extends Object,T extends Object> {
	public T map(E dto, T model) {
		Method[] dtoMethods=dto.getClass().getMethods();
		List<String> dtoGetters=new LinkedList<String>();
		
		//extract all getter from dto methods
		for(Method method: dtoMethods) {
			if(!method.getName().equals("getClass") && method.getName().startsWith("get"))
				dtoGetters.add(method.getName());
		}
		
		for(String getter:dtoGetters) {
			try {
				//get dto properties value
				Object dtoValue=dto.getClass().getMethod(getter).invoke(dto);
				//parse dto getter to model setter
				String modelSetter=getter.replaceFirst("get", "set");
				
				//get properties type
				Class<?> propertyType=model.getClass().getMethod(modelSetter,dtoValue.getClass()).getParameterTypes()[0];
				//classes[0].getClass() modelValue = (classes[0].getClass()) dtoValue;
				model.getClass().getMethod(modelSetter,propertyType).invoke(model, propertyType.cast(dtoValue));
			}
			catch (IllegalAccessException | IllegalArgumentException |InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return model;
	}
}
