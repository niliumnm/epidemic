package com.cdut.epidemicsyscontrolframework.filters;

//@Component
//public class JwtAuthenticationTokenFilter extends OncePerRequestFilter
//{
//
//    @Autowired
//    private SysUserService sysUserService;
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException
//    {
//        String username = JWTUtil.getUsername(request.getHeader("token"));
//        SysUser sysUser = (SysUser)redisUtil.get(username);
//        JWTUtil.verify(request.getHeader("token"), sysUser.getUsername(), sysUser.getPassword());
//
//        if (StringUtils.isNotNull(loginUser) && StringUtils.isNull(SecurityUtils.getAuthentication()))
//        {
//            tokenService.verifyToken(loginUser);
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
//            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        }
//        chain.doFilter(request, response);
//    }
//}
