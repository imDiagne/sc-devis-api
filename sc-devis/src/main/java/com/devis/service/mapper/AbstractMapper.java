package com.devis.service.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;

/**
 * 
 * @author ibrahimamadiodiodiagne
 *
 * @param <E> the class of entity package
 * @param <D> the class of dto package
 */
public abstract class AbstractMapper<E, D> extends ModelMapper {

	/**
	 * Mapping between entity and dto
	 * 
	 * @param source the dto
	 * @return the entity
	 */
	public abstract E convertToEntity(D dto);

	/**
	 * Mapping between dto object and entity object
	 * 
	 * @param source the entity object
	 * @return the dto
	 */
	public abstract D convertToDto(E entity);

	/**
	 * Mapping between the list of dto and entity
	 * @param source the list of dto
	 * @return the list of entity
	 */
	public abstract List<E> convertToListEntity(List<D> dtos);

	/**
	 * Mapping between the list of entity and dto
	 * @param source the list of entity
	 * @return the list of dto
	 */
	public abstract List<D> convertToListDto(List<E> entities);

	/**
	 * Convert set of entity into Dto (if Hibernate return a Set<E>
	 * @param source the Set
	 * @return the list
	 */
	public abstract List<D> convertCollectionToListDto(Collection<E> entities);

	/**
	 * Convert list of entity into Set of Dto
	 * @param source the List
	 * @return the set
	 */
	public abstract Set<D> convertCollectionToSetDto(Collection<E> entities);
}