package camelwatch.rest;

import org.camelwatch.api.CamelBean;
import org.camelwatch.api.CamelConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author Stephen K Samuel samspade79@gmail.com 2 Jul 2012 10:09:57
 */
@Controller
public class ContextRestEndpoint {

    @Autowired
    private CamelConnectionFactory connectionFactory;

    @RequestMapping(value = "/rest/context", method = RequestMethod.GET)
    @ResponseBody
    public List<CamelBean> getConsumer() throws Exception {
        return connectionFactory.getConnection().getContexts();
    }

    @RequestMapping(value = "/rest/context/{camelId}", method = RequestMethod.GET)
    @ResponseBody
    public CamelBean getConsumer(@PathVariable("camelId") String camelId) throws Exception {
        return connectionFactory.getConnection().getContext(camelId);
    }
}
