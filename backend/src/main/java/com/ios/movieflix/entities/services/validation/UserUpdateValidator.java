package com.ios.movieflix.entities.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.ios.movieflix.entities.User;
import com.ios.movieflix.entities.dto.UserDTO;
import com.ios.movieflix.repositories.UserRepository;
import com.ios.movieflix.resources.exceptions.FieldMessage;


public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(UserUpdateValid ann) {
	}

	@Override
	public boolean isValid(UserDTO dto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		var uriVar = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long userId = Long.parseLong(uriVar.get("id"));
		List<FieldMessage> list = new ArrayList<>();
		
		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
		
		User user = userRepository.findByEmail(dto.getEmail());
		if(user != null && userId != user.getId()) {
			list.add(new FieldMessage("email", "Email ja existe."));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
