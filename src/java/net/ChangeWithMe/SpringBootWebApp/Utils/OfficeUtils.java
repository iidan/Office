package net.ChangeWithMe.SpringBootWebApp.Utils;

import org.modelmapper.ModelMapper;

public class OfficeUtils {

    /**
     * Returns the converted Dto To the desired Entity
     *
     * @param obj , classType
     */
    public static <T> T convertDtoToEntity(Object obj, Class<T> classOfT) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(obj, classOfT);
    }
}
