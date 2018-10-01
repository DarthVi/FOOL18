push 0
push 1
push 1
classpippo
new
push function2
push 1
halt

function0:
cfp
lra
push 1
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 2
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 1
srv
sra
pop
sfp
lrv
lra
js
classpippo:
function1
function0
