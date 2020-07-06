package com.topay.users.infra.argumentresolver;

import com.topay.users.infra.exception.InvalidArgumentException;
import com.topay.users.infra.specification.EmployeeSpecification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class EmployeeSpecificationArgumentResolver extends AbstractHandlerMethodArgumentResolver<EmployeeSpecification> {

    @Override
    public EmployeeSpecification resolveArgument(final NativeWebRequest nativeWebRequest) {
        return resolveEmployeeSpecificationParameter(nativeWebRequest);
    }

    /**
     * @param nativeWebRequest
     * @return
     */
    protected EmployeeSpecification resolveEmployeeSpecificationParameter(final NativeWebRequest nativeWebRequest) {
        try {
            return this.getParameterValue(nativeWebRequest);
        } catch (final InvalidArgumentException e) {
            throw new InvalidParameterException(e.getMessage(), e);
        }
    }

    private EmployeeSpecification getParameterValue(final NativeWebRequest nativeWebRequest) {

        final String uuidParameter = nativeWebRequest.getParameter(Field.UUID.name);
        final String nameParameter = nativeWebRequest.getParameter(Field.NAME.name);
        final String emailParameter = nativeWebRequest.getParameter(Field.EMAIL.name);

        UUID id = null;
        String name = null;
        String email = null;

        final List<UUID> uuids = new ArrayList<>();
        final List<String> names = new ArrayList<>();
        final List<String> emails = new ArrayList<>();

        try {
            if(uuidParameter != null)
                id = UUID.fromString(URLDecoder.decode( this.isInvalidArgument(uuidParameter, Field.UUID.name), StandardCharsets.UTF_8.name()));
            if(nameParameter != null)
                name = URLDecoder.decode( this.isInvalidArgument(nameParameter, Field.NAME.name), StandardCharsets.UTF_8.name()) ;
            if(emailParameter != null)
                email = URLDecoder.decode( this.isInvalidArgument(emailParameter, Field.EMAIL.name), StandardCharsets.UTF_8.name()) ;
        } catch (final UnsupportedEncodingException exception) {
            throw new InvalidParameterException(String.format("Unable to decode [%s] to UTF-8"), exception);
        }
        if(id != null)
            uuids.add(id);
        if(name != null)
            names.add(name);
        if(email != null)
            emails.add(email);
        return new EmployeeSpecification( uuids, names, emails);
    }

    private String isInvalidArgument(String parameterValue, String field){
        if ( !ObjectUtils.isEmpty(parameterValue) ){
            return parameterValue;
        }else{
            throw new InvalidArgumentException( String.format("Parâmetro '%s' não pode ser vazio", field) );
        }
    }

    @AllArgsConstructor
    protected enum Field {

        UUID("uuid"),
        EMAIL("email"),
        NAME("name");

        private final String name;

    }
}
