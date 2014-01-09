package ch.lepeit.brain2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ch.lepeit.brain2.model.DeployArtefakt;

/**
 * Backing bean for DeployArtefakt entities.
 * <p>
 * This class provides CRUD functionality for all DeployArtefakt entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD framework or
 * custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class DeployArtefaktBean implements Serializable
{

   private static final long serialVersionUID = 1L;

   /*
    * Support creating and retrieving DeployArtefakt entities
    */

   private Integer id;

   public Integer getId()
   {
      return this.id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   private DeployArtefakt deployArtefakt;

   public DeployArtefakt getDeployArtefakt()
   {
      return this.deployArtefakt;
   }

   @Inject
   private Conversation conversation;

   @PersistenceContext(type = PersistenceContextType.EXTENDED)
   private EntityManager entityManager;

   public String create()
   {

      this.conversation.begin();
      return "create?faces-redirect=true";
   }

   public void retrieve()
   {

      if (FacesContext.getCurrentInstance().isPostback())
      {
         return;
      }

      if (this.conversation.isTransient())
      {
         this.conversation.begin();
      }

      if (this.id == null)
      {
         this.deployArtefakt = this.example;
      }
      else
      {
         this.deployArtefakt = findById(getId());
      }
   }

   public DeployArtefakt findById(Integer id)
   {

      return this.entityManager.find(DeployArtefakt.class, id);
   }

   /*
    * Support updating and deleting DeployArtefakt entities
    */

   public String update()
   {
      this.conversation.end();

      try
      {
         if (this.id == null)
         {
            this.entityManager.persist(this.deployArtefakt);
            return "search?faces-redirect=true";
         }
         else
         {
            this.entityManager.merge(this.deployArtefakt);
            return "view?faces-redirect=true&id=" + this.deployArtefakt.getId();
         }
      }
      catch (Exception e)
      {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
         return null;
      }
   }

   public String delete()
   {
      this.conversation.end();

      try
      {
         DeployArtefakt deletableEntity = findById(getId());

         this.entityManager.remove(deletableEntity);
         this.entityManager.flush();
         return "search?faces-redirect=true";
      }
      catch (Exception e)
      {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
         return null;
      }
   }

   /*
    * Support searching DeployArtefakt entities with pagination
    */

   private int page;
   private long count;
   private List<DeployArtefakt> pageItems;

   private DeployArtefakt example = new DeployArtefakt();

   public int getPage()
   {
      return this.page;
   }

   public void setPage(int page)
   {
      this.page = page;
   }

   public int getPageSize()
   {
      return 10;
   }

   public DeployArtefakt getExample()
   {
      return this.example;
   }

   public void setExample(DeployArtefakt example)
   {
      this.example = example;
   }

   public void search()
   {
      this.page = 0;
   }

   public void paginate()
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

      // Populate this.count

      CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
      Root<DeployArtefakt> root = countCriteria.from(DeployArtefakt.class);
      countCriteria = countCriteria.select(builder.count(root)).where(
            getSearchPredicates(root));
      this.count = this.entityManager.createQuery(countCriteria)
            .getSingleResult();

      // Populate this.pageItems

      CriteriaQuery<DeployArtefakt> criteria = builder.createQuery(DeployArtefakt.class);
      root = criteria.from(DeployArtefakt.class);
      TypedQuery<DeployArtefakt> query = this.entityManager.createQuery(criteria
            .select(root).where(getSearchPredicates(root)));
      query.setFirstResult(this.page * getPageSize()).setMaxResults(
            getPageSize());
      this.pageItems = query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<DeployArtefakt> root)
   {

      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      int id = this.example.getId();
      if (id != 0)
      {
         predicatesList.add(builder.equal(root.get("id"), id));
      }
      String name = this.example.getName();
      if (name != null && !"".equals(name))
      {
         predicatesList.add(builder.like(root.<String> get("name"), '%' + name + '%'));
      }
      String groupId = this.example.getGroupId();
      if (groupId != null && !"".equals(groupId))
      {
         predicatesList.add(builder.like(root.<String> get("groupId"), '%' + groupId + '%'));
      }
      String artefaktId = this.example.getArtefaktId();
      if (artefaktId != null && !"".equals(artefaktId))
      {
         predicatesList.add(builder.like(root.<String> get("artefaktId"), '%' + artefaktId + '%'));
      }
      String extension = this.example.getExtension();
      if (extension != null && !"".equals(extension))
      {
         predicatesList.add(builder.like(root.<String> get("extension"), '%' + extension + '%'));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }

   public List<DeployArtefakt> getPageItems()
   {
      return this.pageItems;
   }

   public long getCount()
   {
      return this.count;
   }

   /*
    * Support listing and POSTing back DeployArtefakt entities (e.g. from inside an
    * HtmlSelectOneMenu)
    */

   public List<DeployArtefakt> getAll()
   {

      CriteriaQuery<DeployArtefakt> criteria = this.entityManager
            .getCriteriaBuilder().createQuery(DeployArtefakt.class);
      return this.entityManager.createQuery(
            criteria.select(criteria.from(DeployArtefakt.class))).getResultList();
   }

   @Resource
   private SessionContext sessionContext;

   public Converter getConverter()
   {

      final DeployArtefaktBean ejbProxy = this.sessionContext.getBusinessObject(DeployArtefaktBean.class);

      return new Converter()
      {

         @Override
         public Object getAsObject(FacesContext context,
               UIComponent component, String value)
         {

            return ejbProxy.findById(Integer.valueOf(value));
         }

         @Override
         public String getAsString(FacesContext context,
               UIComponent component, Object value)
         {

            if (value == null)
            {
               return "";
            }

            return String.valueOf(((DeployArtefakt) value).getId());
         }
      };
   }

   /*
    * Support adding children to bidirectional, one-to-many tables
    */

   private DeployArtefakt add = new DeployArtefakt();

   public DeployArtefakt getAdd()
   {
      return this.add;
   }

   public DeployArtefakt getAdded()
   {
      DeployArtefakt added = this.add;
      this.add = new DeployArtefakt();
      return added;
   }
}