package jp.co.btc.hrms.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import jp.co.btc.hrms.domain.Member;
import jp.co.btc.hrms.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Path("/members")
@Component
public class MemberController {

  @Autowired
  private MemberService memberService;
  private Map<String, Object> returnValue = new HashMap<String, Object>();

  /**
   * .
   * @param member member information
   * @return result map
   */
  @POST
  @Path("add")
  @Consumes("application/json;charset=UTF-8")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Object> post(@RequestBody Member member) {
    returnValue.clear();
    memberService.save(member);
    returnValue.put("code", 200);
    returnValue.put("msg", "success");
    returnValue.put("action", "add ");
    returnValue.put("data", member);
    return returnValue;
  }


  /**
   * .
   * @param member member information
   * @return result map
   */
  @POST
  @Path("adminlogin")
  @Consumes("application/json;charset=UTF-8")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Object> adminLogin(@RequestBody Member member) {
    returnValue.clear();
    memberService.save(member);
    returnValue.put("code", 200);
    returnValue.put("msg", "success");
    returnValue.put("action", "add ");
    returnValue.put("data", member);
    return returnValue;
  }


  /**
   * .
   * @param member member information
   * @return result map
   */
  @POST
  @Path("login")
  @Consumes("application/json;charset=UTF-8")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Object> login(@RequestBody Member member) {
    returnValue.clear();
    Long id = memberService.login(member);
    if (id != null && id != 0) {
      returnValue.put("islogin", true);
      returnValue.put("data", memberService.getById(id));
    } else {
      returnValue.put("islogin", false);
    }
    returnValue.put("code", 200);
    returnValue.put("msg", "success");
    returnValue.put("action", "login ");
    return returnValue;
  }


  /**
   * .
   * @param id member's id
   * @return result map
   */
  @DELETE
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Object> delete(@PathParam("id") Long id) {
    returnValue.clear();
    memberService.delete(id);
    returnValue.put("code", 200);
    returnValue.put("msg", "success");
    returnValue.put("action", "delete ");
    return returnValue;
  }


  /**
   * .
   * @param member member information
   * @return result map
   */
  @PUT
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Object> put(@PathParam("id") Long id, @RequestBody Member member) {
    returnValue.clear();
    member.setId(id);
    System.out.println("===============" + member);
    memberService.update(member);
    returnValue.put("code", 200);
    returnValue.put("msg", "success");
    returnValue.put("action", "put update");
    return returnValue;
  }

  /**
   * .
   * @param id search member by id
   * @return result map
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Object> get(@PathParam("id") Long id) {
    returnValue.clear();
    returnValue.put("code", 200);
    returnValue.put("msg", "success");
    returnValue.put("action", "getById");
    returnValue.put("data", memberService.getById(id));
    return returnValue;
  }

  /**
   * .
   * @param membername search member by name
   * @return result map
   */
  @GET
  @Path("membername")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Object> getByMemberName(@PathParam("name") String membername) {
    returnValue.clear();
    Member member = memberService.isSign(membername);
    if (member != null) {
      returnValue.put("issign", true);
      returnValue.put("data", member);
    } else {
      returnValue.put("issign", false);
    }
    returnValue.put("code", 200);
    returnValue.put("msg", "success");
    returnValue.put("action", "getById");
    return returnValue;
  }

  //http://127.0.0.1:8080/rest/xxx/list?page=0&size=20
  /**
   * .
   * @param page page index
   * @param size get result size
   * @return result map
   */
  @GET
  @Path("list")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Object> getList(@DefaultValue("0") @QueryParam("page") Integer page,
      @DefaultValue("20") @QueryParam("size") Integer size) {
    returnValue.clear();
    Sort sort = new Sort(Direction.DESC, "id");
    Pageable pageable = new PageRequest(page, size, sort);
    returnValue.put("code", 200);
    returnValue.put("msg", "success");
    returnValue.put("action", "getpageList");
    returnValue.put("data", memberService.findList(pageable));
    return returnValue;
  }


  /**
   * .
   * @param pagesize page sizes
   * @param currentpage current pages
   * @return result map
   */
  @GET
  @Path("/page/{pagesize}/{currentpage}")
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Object> getPage(@DefaultValue("20") @PathParam("pagesize") Integer pagesize,
      @DefaultValue("1") @PathParam("currentpage") Integer currentpage) {
    returnValue.clear();
    List<Member> members = new ArrayList<Member>();
    returnValue.put("members", members);
    return returnValue;
  }

}
